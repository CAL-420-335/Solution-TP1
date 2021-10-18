package org.cal.TP1.cli;

import com.googlecode.lanterna.gui2.Button;
import com.googlecode.lanterna.gui2.Panel;

public class ListMenuPanel extends Panel {
    public ListMenuPanel(CliApp app) {
        super();

        new Button("Tâches non assignés", app::listeTacheNonAssigne).addTo(this);
        new Button("Toutes les fonctions", app::listeFonctions).addTo(this);
        new Button("Employés par fonction", app::listeEmployeesParFonction).addTo(this);
        new Button("Tous les employés", app::listeEmployees).addTo(this);
    }
}
