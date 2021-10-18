package org.cal.TP1.cli;

import com.googlecode.lanterna.gui2.BorderLayout;
import com.googlecode.lanterna.gui2.Button;
import com.googlecode.lanterna.gui2.Panel;

public class ListControlPanel extends Panel {
    Button next;
    Button previous;

    public ListControlPanel(Runnable nextAction, Runnable previousAction, Runnable closeAction){
        super(new BorderLayout());

        Panel nextPreviousPanel = new Panel(new BorderLayout()).setLayoutData(BorderLayout.Location.TOP).addTo(this);
        previous = new Button("Précédent", previousAction).setLayoutData(BorderLayout.Location.LEFT).addTo(nextPreviousPanel);
        next = new Button("Suivant", nextAction).setLayoutData(BorderLayout.Location.RIGHT).addTo(nextPreviousPanel);

        new Button("Fermer", closeAction).setLayoutData(BorderLayout.Location.BOTTOM).addTo(this);
    }

    public void setNextEnabled(boolean enable){
        next.setEnabled(enable);
    }

    public void setPreviousEnabled(boolean enable){
        previous.setEnabled(enable);
    }

}
