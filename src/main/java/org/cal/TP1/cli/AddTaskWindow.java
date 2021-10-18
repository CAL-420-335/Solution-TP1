package org.cal.TP1.cli;

import com.googlecode.lanterna.gui2.*;
import org.cal.TP1.db.IDbController;

public class AddTaskWindow extends BasicWindow {
    AddTaskFormPanel form;
    IDbController controller;

    public AddTaskWindow(IDbController controller) {
        super();

        this.controller = controller;

        Panel content = new Panel().setLayoutManager(new BorderLayout());;

        form = new AddTaskFormPanel();
        form.setLayoutData(BorderLayout.Location.CENTER).addTo(content);

        new SaveClosePanel(this::save, this::close)
                .setLayoutData(BorderLayout.Location.BOTTOM).addTo(content);

        setComponent(content);
    }

    private void save(){
        controller.ajouterNouvelleTache(form.getDescription(), form.getPriorite(), form.getDateCreation(), form.getFonction());
        this.close();
    }
}
