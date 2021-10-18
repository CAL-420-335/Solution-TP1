package org.cal.TP1.cli;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;

import java.time.LocalDate;

public class AddTaskFormPanel extends Panel {
    private TextBox description;
    private RadioBoxList priority;
    private TextBox date;
    private TextBox function;

    public AddTaskFormPanel(){
        super();

        setLayoutManager(new GridLayout(2));

        new Label("Description").addTo(this);
        description = new TextBox().setPreferredSize(new TerminalSize(40, 1)).addTo(this);

        new Label("Priorite").addTo(this);
        priority = new RadioBoxList();
        priority.addItem("HIGH").addItem("MEDIUM").addItem("LOW");
        priority.setCheckedItemIndex(0);
        priority.addTo(this);

        new Label("Date Creation").addTo(this);
        date = new TextBox().setPreferredSize(new TerminalSize(20, 1));
        date.setText(LocalDate.now().toString());
        date.addTo(this);

        new Label("Fonction").addTo(this);
        function = new TextBox().setPreferredSize(new TerminalSize(20, 1)).addTo(this);
    }

    public String getDescription(){ return description.getText(); }
    public String getPriorite(){ return priority.getCheckedItem().toString(); }
    public String getDateCreation(){ return date.getText(); }
    public String getFonction(){ return function.getText(); }
}
