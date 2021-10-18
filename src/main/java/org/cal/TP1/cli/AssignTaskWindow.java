package org.cal.TP1.cli;

import com.googlecode.lanterna.gui2.*;
import org.cal.TP1.db.IDbController;

public class AssignTaskWindow extends BasicWindow {
    Label message;
    Button closeBtn;
    IDbController controller;

    public AssignTaskWindow(IDbController controller){
        super();

        this.controller = controller;

        Panel content = new Panel().setLayoutManager(new BorderLayout());
        new Label("Assignation des taches...");

        setComponent(content);

        message = new Label("Assignation des taches...")
                .setLayoutData(BorderLayout.Location.CENTER).addTo(content);

        closeBtn = new Button("Fermer", this::close).setVisible(false).setEnabled(false)
                .setLayoutData(BorderLayout.Location.BOTTOM).addTo(content);
    }

    public void run(){
        message.setText("Assignation des taches...");
        closeBtn.setVisible(false).setEnabled(false);

        controller.assignerTaches();
        try {
            Thread.sleep(1000);
        }catch (Exception e) {}

        message.setText("Assignation des taches complete!");
        closeBtn.setVisible(true).setEnabled(true);
        setFocusedInteractable(closeBtn);
    }
}
