package org.cal.TP1.db;

import java.util.List;

public interface IDb {
    public void ajouterTache(Tache t);
    public void ajouterEmploye(Employe e);
    public void assignerTaches();

    public Iterable<Tache> getTachesNonAssignees();
    public Iterable<String> getFonctions();
    public List<Employe> getEmployesParFonction(String fonction);
    public List<Employe> getEmployes();
}
