package org.cal.TP1.cli;

import com.googlecode.lanterna.gui2.Button;
import com.googlecode.lanterna.gui2.Panel;

public class ActionMenuPanel extends Panel {
    public ActionMenuPanel(CliApp app) {
        super();

        new Button("Assigner les tâches", app::assignerTaches).addTo(this);
        new Button("Ajouter une tâche", app::ajouterTache).addTo(this);
        new Button("Ajouter un employé", app::ajouterEmploye).addTo(this);
    }
}
