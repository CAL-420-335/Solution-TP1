package org.cal.TP1.db;

public enum Priorite {
    LOW(1),
    MEDIUM(2),
    HIGH(3);

    private int poids;

    Priorite(int p){this.poids = p;}
    public int poids(){
        return this.poids;
    }
}
