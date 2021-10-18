package org.cal.TP1.db;

import java.util.*;

public class Db implements IDb{

    List<Employe> employes = new ArrayList<>();
    List<Tache> tachesNonAssigne = new ArrayList<>();
    Map<String, List<Employe>> employesParFonction = new HashMap<>();
    Map<String, PriorityQueue<Tache>> tachesParFonction = new HashMap<>();
    Set<String> fonctions = new HashSet<>();

    @Override
    public void ajouterTache(Tache t) {
        fonctions.add(t.getFonction());
        tachesNonAssigne.add(t);
        tachesParFonction.computeIfAbsent(t.getFonction(),
                (k) -> new PriorityQueue<>(new TachePrioriteComparator())).add(t);
    }

    @Override
    public void ajouterEmploye(Employe e) {
        fonctions.add(e.getFonction());
        employes.add(e);
        employesParFonction.computeIfAbsent(e.getFonction(),
                (k) -> new ArrayList<Employe>()).add(e);
    }

    @Override
    public void assignerTaches() {
        List<Tache> tachesNonAssigne = new ArrayList<>();

        for(Map.Entry<String, PriorityQueue<Tache>> entry : tachesParFonction.entrySet()) {
            List<Employe> employes = employesParFonction.getOrDefault(entry.getKey(), Collections.emptyList());
            PriorityQueue<Tache> taches = entry.getValue();

            if(employes.size() == 0) {
                tachesNonAssigne.addAll(taches);
                taches.clear();
            }
            else {
                assigneTacheFonction(taches, employes);
            }
        }

        this.tachesNonAssigne = tachesNonAssigne;
    }

    @Override
    public Iterable<Tache> getTachesNonAssignees() {
        return tachesNonAssigne;
    }

    @Override
    public Iterable<String> getFonctions() {
        return fonctions;
    }

    @Override
    public List<Employe> getEmployesParFonction(String fonction) {
        return employesParFonction.getOrDefault(fonction, Collections.emptyList());
    }

    @Override
    public List<Employe> getEmployes() {
        return employes;
    }

    private void assigneTacheFonction(PriorityQueue<Tache> taches, List<Employe> employes) {
        int empIdx = 0;
        while(!taches.isEmpty()) {
            employes.get(empIdx++ % employes.size()).addTache(taches.poll());
        }
    }
}
