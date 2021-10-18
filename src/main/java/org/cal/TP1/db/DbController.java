package org.cal.TP1.db;

import java.time.LocalDate;
import java.util.List;

public class DbController implements IDbController{

    IDb db;

    public DbController(){
        this.db = new Db();
    }

    public DbController(IDb db){
        this.db = db;
    }

    @Override
    public void assignerTaches() {
        this.db.assignerTaches();
    }

    @Override
    public void ajouterEmploye(String nom, String fonction) {
        validNotNullNorEmpty("nom", nom);
        validNotNullNorEmpty("fonction", fonction);

        db.ajouterEmploye(new Employe(nom, fonction));
    }

    @Override
    public void ajouterNouvelleTache(String description, String priorite, String dateCreation, String fonction) {
        validNotNullNorEmpty("description", description);
        validNotNullNorEmpty("priorite", priorite);
        validNotNullNorEmpty("dateCreation", dateCreation);
        validNotNullNorEmpty("fonction", fonction);

        Priorite prio = Priorite.valueOf(priorite);
        LocalDate date = LocalDate.parse(dateCreation);

        if(date.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("date de creation est dans le futur");
        }

        db.ajouterTache(new Tache(description, prio, date, fonction));
    }

    @Override
    public Iterable<Tache> getTachesNonAssignes() {
        return db.getTachesNonAssignees();
    }

    @Override
    public Iterable<Tache> getTachesAssignes(Employe e) {
        return e.getTaches();
    }

    @Override
    public Iterable<String> getFonctions() {
        return db.getFonctions();
    }

    @Override
    public List<Employe> getEmployes() {
        return db.getEmployes();
    }

    @Override
    public List<Employe> getEmployesParFonction(String fonction) {
        return db.getEmployesParFonction(fonction);
    }

    private void validNotNullNorEmpty(String fieldname, String val) {
        if(val == null || val.isBlank()) {
            throw new IllegalArgumentException(fieldname + " vide ou null");
        }
    }
}
