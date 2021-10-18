package org.cal.TP1.cli;

import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.table.Table;
import org.cal.TP1.db.IDbController;
import org.cal.TP1.db.Tache;

public class ListTaskWindow extends BasicWindow {
    private IDbController controller;
    private Iterable<Tache> tasks;
    private ListControlPanel controls;
    private Table<String> table;


    public ListTaskWindow(IDbController controller, String title, Iterable<Tache> tasks) {
        super();

        this.controller = controller;
        this.tasks = tasks;

        Panel content = new Panel().setLayoutManager(new BorderLayout());

        new Label(title).setLayoutData(BorderLayout.Location.TOP).addTo(content);
        new Button("Fermer", this::close)
                .setLayoutData(BorderLayout.Location.BOTTOM).addTo(content);

        table = new Table<String>("Priorite", "Date", "Fonction", "Description")
                .setLayoutData(BorderLayout.Location.CENTER).addTo(content);

        for(Tache t : tasks) {
            table.getTableModel().addRow( t.getPriorite().toString(),
                    t.getDateCreation().toString(),
                    t.getFonction(),
                    t.getDescription());
        }

        setComponent(content);
    }

}
