package org.cal.TP1.cli;

import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.table.Table;
import org.cal.TP1.db.Employe;
import org.cal.TP1.db.IDbController;

import java.util.List;

public class ListEmployeeWindow extends BasicWindow {
    final private int PAGE_SIZE = 10;
    private int empIdx = 0;

    private IDbController controller;
    private MultiWindowTextGUI gui;

    private List<Employe> employees;
    private ListControlPanel controls;
    private Table<String> table;

    private Label lblEmpName;
    private Label lblEmpFunction;

    public ListEmployeeWindow(MultiWindowTextGUI gui,
                              IDbController controller,
                              String dept,
                              List<Employe> employees) {
        super();

        this.controller = controller;
        this.gui = gui;
        this.employees = employees;

        Panel content = new Panel().setLayoutManager(new BorderLayout());

        new Label("Liste des employés : " + dept).setLayoutData(BorderLayout.Location.TOP).addTo(content);

        Panel empInfoPane = new Panel(new BorderLayout())
                .setLayoutData(BorderLayout.Location.CENTER).addTo(content);

        new Button("Ouvrir liste tâches", this::displayListTasks)
                .setLayoutData(BorderLayout.Location.BOTTOM).addTo(empInfoPane);

        Panel empInfoWrapper = new Panel(new LinearLayout(Direction.VERTICAL))
                .setLayoutData(BorderLayout.Location.CENTER).addTo(empInfoPane);

        lblEmpName = new Label("Nom : ").addTo(empInfoWrapper);
        lblEmpFunction = new Label("Fonction : ").addTo(empInfoWrapper);

        controls = new ListControlPanel(this::next, this::previous, this::close);
        controls.setLayoutData(BorderLayout.Location.BOTTOM).addTo(content);

        setComponent(content);

        displayEmployee(empIdx);
    }

    public void next(){
        if(empIdx < employees.size())
            displayEmployee(++empIdx);
    }

    public void previous() {
        if(empIdx > 0)
            displayEmployee(--empIdx);
    }

    private void displayEmployee(int empIdx) {
        lblEmpName.setText("Nom : ");
        lblEmpFunction.setText("Fonction : ");

        if(empIdx >= 0 && empIdx < employees.size()) {
            Employe e = employees.get(empIdx);
            lblEmpName.setText("Nom : " + e.getNom());
            lblEmpFunction.setText("Fonction : " + e.getFonction());
        }

        controls.setNextEnabled(empIdx < employees.size() - 1);
        controls.setPreviousEnabled(empIdx > 0);
    }

    private void displayListTasks(){
        Employe e = employees.get(empIdx);
        ListTaskWindow window = new ListTaskWindow(controller, "Tâches pour l'employé '" + e.getNom() + "'",
                this.controller.getTachesAssignes(e));
        gui.addWindowAndWait(window);
    }
}
