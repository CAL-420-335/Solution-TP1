package org.cal.TP1.cli;

import com.googlecode.lanterna.gui2.*;

import java.util.Arrays;

public class MainWindow extends BasicWindow {
    public MainWindow(CliApp app){
        super();

        Panel wrapperPanel = new Panel().setLayoutManager(new BorderLayout());

        new Panel().setLayoutManager(new LinearLayout(Direction.HORIZONTAL))
                .addComponent(new ListMenuPanel(app).withBorder(Borders.singleLine("Menu de listes")))
                .addComponent(new ActionMenuPanel(app).withBorder(Borders.singleLine("Menu d'action")))
                .setLayoutData(BorderLayout.Location.CENTER)
                .addTo(wrapperPanel);

        new Button("Quitter", this::close).setLayoutData(BorderLayout.Location.BOTTOM).addTo(wrapperPanel);

        setComponent(wrapperPanel);
        setHints(Arrays.asList(Window.Hint.CENTERED));
    }
}
