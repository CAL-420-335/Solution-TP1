package org.cal.TP1.db;

import java.util.Comparator;

public class TachePrioriteComparator implements Comparator<Tache> {
    @Override
    public int compare(Tache o1, Tache o2) {
        if(o1 == o2) return 0;

        int res = 0;

        if(o2 == null) res = 1;
        if(o1 == null) res = -1;

        if(res == 0) {
            res = o1.getPriorite().compareTo(o2.getPriorite());
        }

        if(res == 0) {
            res = o1.getDateCreation().compareTo(o2.getDateCreation());
        }

        return res * -1;
    }
}
