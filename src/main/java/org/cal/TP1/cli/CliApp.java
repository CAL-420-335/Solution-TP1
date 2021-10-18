package org.cal.TP1.cli;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.dialogs.MessageDialog;
import com.googlecode.lanterna.gui2.dialogs.TextInputDialog;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.*;
import org.cal.TP1.db.IDbController;

import java.util.Arrays;

public class CliApp {

    private MultiWindowTextGUI gui = null;
    IDbController controller = null;

    public CliApp(IDbController controller) {
        this.controller = controller;
    }

    public void start(){
        DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();
        Terminal terminal = null;
        try {
            terminal = defaultTerminalFactory.createTerminal();
            terminal.enterPrivateMode();

            Screen screen = new TerminalScreen(terminal);
            screen.startScreen();

            gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.BLUE));
            gui.addWindowAndWait(new MainWindow(this));

            screen.close();
            terminal.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void listeTacheNonAssigne() {
        ListTaskWindow window
                = new ListTaskWindow(controller, "Liste des tâches non assignées", controller.getTachesNonAssignes());

        window.setHints(Arrays.asList(Window.Hint.CENTERED));
        try {
            gui.addWindowAndWait(window);
        }catch (Exception e) {
            MessageDialog.showMessageDialog(gui, "Erreur!!!", "Erreur : " + e.getMessage());
            window.close();
        }
    }

    public void listeFonctions() {
        ListFunctionWindow window
                = new ListFunctionWindow(controller, controller.getFonctions());

        window.setHints(Arrays.asList(Window.Hint.CENTERED));
        try {
            gui.addWindowAndWait(window);
        }catch (Exception e) {
            MessageDialog.showMessageDialog(gui, "Erreur!!!", "Erreur : " + e.getMessage());
            window.close();
        }
    }

    public void listeEmployeesParFonction() {

        String fonction = TextInputDialog.showDialog(gui, "Fonction?", "Entrez la Fonction : ", "");

        if(fonction != null && !fonction.equals("")) {
            ListEmployeeWindow window
                    = new ListEmployeeWindow(gui, controller, fonction, controller.getEmployesParFonction(fonction));

            window.setHints(Arrays.asList(Window.Hint.CENTERED));
            try {
                gui.addWindowAndWait(window);
            } catch (Exception e) {
                MessageDialog.showMessageDialog(gui, "Erreur!!!", "Erreur : " + e.getMessage());
                window.close();
            }
        }
    }

    public void listeEmployees() {
        ListEmployeeWindow window
                = new ListEmployeeWindow(gui, controller, "*ALL*", controller.getEmployes());

        window.setHints(Arrays.asList(Window.Hint.CENTERED));
        try {
            gui.addWindowAndWait(window);
        }catch (Exception e) {
            MessageDialog.showMessageDialog(gui, "Erreur!!!", "Erreur : " + e.getMessage());
            window.close();
        }
    }

    public void assignerTaches(){
        AssignTaskWindow window = new AssignTaskWindow(controller);
        window.setHints(Arrays.asList(Window.Hint.CENTERED));

        try {
            gui.addWindow(window);
            gui.updateScreen();
            window.run();
        }catch (Exception e) {
            MessageDialog.showMessageDialog(gui, "Erreur!!!", "Erreur : " + e.getMessage());
            window.close();
        }
    }

    public void ajouterTache(){
        Window window = new AddTaskWindow(controller);

        window.setHints(Arrays.asList(Window.Hint.CENTERED));
        try {
            gui.addWindowAndWait(window);
        }catch (Exception e) {
            MessageDialog.showMessageDialog(gui, "Erreur!!!", "Erreur : " + e.getMessage());
            window.close();
        }
    }

    public void ajouterEmploye(){
        Window window = new AddEmployeeWindow(controller);
        window.setHints(Arrays.asList(Window.Hint.CENTERED));
        try {
            gui.addWindowAndWait(window);
        }catch (Exception e) {
            MessageDialog.showMessageDialog(gui, "Erreur!!!", "Erreur : " + e.getMessage());
            window.close();
        }
    }
}
