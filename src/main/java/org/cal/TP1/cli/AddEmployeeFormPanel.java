package org.cal.TP1.cli;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;

public class AddEmployeeFormPanel extends Panel {
    private TextBox description;
    private TextBox fonction;

    public AddEmployeeFormPanel() {
        super();

        setLayoutManager(new GridLayout(2));

        new Label("Nom").addTo(this);
        description = new TextBox().setPreferredSize(new TerminalSize(40, 1)).addTo(this);

        new Label("Fonction").addTo(this);
        fonction = new TextBox().setPreferredSize(new TerminalSize(20, 1)).addTo(this);
    }

    public String getNom(){ return description.getText(); }
    public String getFonction(){ return fonction.getText(); }
}
