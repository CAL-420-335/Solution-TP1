package org.cal.TP1.cli;

import com.googlecode.lanterna.gui2.*;
import org.cal.TP1.db.IDbController;

public class AddEmployeeWindow extends BasicWindow{
    AddEmployeeFormPanel form;
    IDbController controller;

    public AddEmployeeWindow(IDbController controller){
        super();

        this.controller = controller;

        Panel content = new Panel().setLayoutManager(new BorderLayout());;

        form = new AddEmployeeFormPanel();
        form.setLayoutData(BorderLayout.Location.CENTER).addTo(content);

        new SaveClosePanel( this::handleSave, this::close )
                .setLayoutData(BorderLayout.Location.BOTTOM).addTo(content);

        setComponent(content);
    }

    private void handleSave(){
        controller.ajouterEmploye(form.getNom(), form.getFonction());
        this.close();
    }
}
