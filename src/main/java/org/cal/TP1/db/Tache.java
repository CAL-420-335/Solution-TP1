package org.cal.TP1.db;

import java.time.LocalDate;

public class Tache {
    private String description;
    private Priorite priorite;
    private LocalDate dateCreation;
    private String fonction;

    public Tache(String description, Priorite priorite, LocalDate dateCreation, String fonction){
        this.description = description;
        this.priorite = priorite;
        this.dateCreation = dateCreation;
        this.fonction = fonction;
    }

    public String getFonction(){
        return this.fonction;
    }

    public String getDescription(){
        return this.description;
    }

    public Priorite getPriorite() {
        return this.priorite;
    }

    public LocalDate getDateCreation() {
        return this.dateCreation;
    }
}
