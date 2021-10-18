package org.cal.TP1.db;

import java.util.List;

public interface IDbController {
    public void assignerTaches();
    public void ajouterEmploye(String nom, String fonction);
    public void ajouterNouvelleTache(String description, String priorite, String dateCreation, String fonction);

    public Iterable<Tache> getTachesNonAssignes();
    public Iterable<Tache> getTachesAssignes(Employe e);
    public Iterable<String> getFonctions();
    public List<Employe> getEmployes();
    public List<Employe> getEmployesParFonction(String fonction);
}
