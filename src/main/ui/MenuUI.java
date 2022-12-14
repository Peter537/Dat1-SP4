package main.ui;

import main.FormulaOne;
import main.data.ITeam;
import main.data.IUser;
import main.database.DataBaseIO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MenuUI extends AUI {

    private JTabbedPane tabbedPane1;
    private JPanel MenuPanel;
    private JList driverLeaderboard;
    private JList teamLeaderboard;
    private JLabel teamLeadTitle;
    private JScrollPane teamLeadScroll;
    private JScrollPane driverLeadScroll;
    private JLabel driverLeadTitle;
    private JPanel MyTeam;
    private JTabbedPane tabbedPane2;
    private JLabel carpng1;
    private JLabel driver2Text;
    private JButton changeTeamButton;
    private JLabel myTeam;
    private FormulaOne formulaOne;
    private IUser currentUser;

    public JPanel getPanel() {
        return MenuPanel;
    }

    public MenuUI(FormulaOne formulaOne) {
        super();
        this.formulaOne = formulaOne;
        teamLeaderboard.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // Get the selected item and display a message
                String selectedItem = (String) teamLeaderboard.getSelectedValue();
                JOptionPane.showMessageDialog(null, "You selected: " + selectedItem);
                System.out.println(selectedItem);
            }
        });

        if (formulaOne.getSessionCache().getCurrentUser() != null) {
            currentUser = formulaOne.getSessionCache().getCurrentUser();
        }

        setData(this);
    }

    public void setData(MenuUI data) {
        ArrayList<ITeam> teams = DataBaseIO.loadDefaultTeamData(); //TODO: maybe change to teamleaderboard class
        ArrayList<String> values = new ArrayList<>();
        // Add header
        values.add("Points | Team | Driver 1 | Driver 2 | Car");
        for (ITeam team : teams) {
            values.add(
                team.getPoints() + " | " +
                team.getName() + " | " +
                team.getDriver1().getName() + " | " +
                team.getDriver2().getName() + " | " +
                team.getCar().getName()
            );
        }

        teamLeaderboard.setListData(values.toArray());

        if (currentUser != null) {
            myTeam.setText(currentUser.getTeam().getName());
        }

        if (currentUser != null) {
            driver2Text.setText(currentUser.getTeam().getDriver2().getName());
        }

        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                IUI chooseTeam = new ChooseTeamUI(formulaOne);
                chooseTeam.updatePane(chooseTeam);
            }
        };
        changeTeamButton.addActionListener(actionListener);
    }

    public void getData(MenuUI data) {
    }

    @Override
    public void updatePane(IUI ui) {
        if (formulaOne.getSessionCache().getCurrentUser() == null) {
            JOptionPane.showMessageDialog(null, "No team currently selected. Please select a team from the list.");
            IUI chooseTeam = new ChooseTeamUI(formulaOne);
            chooseTeam.updatePane(chooseTeam);
        }
        else {
            currentUser = formulaOne.getSessionCache().getCurrentUser();
            FormulaOne.getPage().setContentPane(ui.getPanel());
            FormulaOne.getPage().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            FormulaOne.getPage().pack();
            FormulaOne.getPage().setVisible(true);
        }
    }

    public boolean isModified(MenuUI data) {
        return false;
    }
}