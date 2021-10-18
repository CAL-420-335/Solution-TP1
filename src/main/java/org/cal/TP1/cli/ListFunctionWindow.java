package org.cal.TP1.cli;

import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.table.Table;
import org.cal.TP1.db.IDbController;

public class ListFunctionWindow extends BasicWindow {
    final private int PAGE_SIZE = 10;
    private int empIdx = 0;

    private IDbController controller;

    private ListControlPanel controls;
    private Table<String> table;


    public ListFunctionWindow(IDbController controller,
                              Iterable<String> functions) {
        super();

        this.controller = controller;

        Panel content = new Panel().setLayoutManager(new BorderLayout());

        table = new Table<>("Fonction");
        table.setLayoutData(BorderLayout.Location.CENTER).addTo(content);

        new Button("Fermer", this::close)
                .setLayoutData(BorderLayout.Location.BOTTOM).addTo(content);

        for(String f : functions) {
            table.getTableModel().addRow(f);
        }

        setComponent(content);
    }



}
