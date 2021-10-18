package org.cal.TP1.cli;

import com.googlecode.lanterna.gui2.*;

public class SaveClosePanel extends Panel {

    public SaveClosePanel(Runnable saveAction, Runnable closeAction){
        super();

        setLayoutManager(new LinearLayout(Direction.VERTICAL));

        new Button("Sauvegarder", saveAction)
                .setLayoutData(LinearLayout.createLayoutData(LinearLayout.Alignment.Center))
                .addTo(this);

        Button fermer = new Button("Fermer", closeAction)
                .setLayoutData(LinearLayout.createLayoutData(LinearLayout.Alignment.Center))
                .addTo(this);
    }
}
