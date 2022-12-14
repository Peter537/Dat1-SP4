package main.ui;

import main.FormulaOne;
import main.data.IDriver;
import main.data.ITeam;
import main.data.IUser;
import main.database.DataBaseIO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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
    private JLabel driver1Text;
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
            formulaOne.getSessionCache().setCurrentUser(currentUser);
        }

        setData(this);
    }

    public void setData(MenuUI data) {
        ArrayList<ITeam> teams = formulaOne.getSessionCache().getTeams(); //TODO: maybe change to teamleaderboard class
        ArrayList<IDriver> drivers = new ArrayList<>();
        ArrayList<String> values = new ArrayList<>(); //This can also be done with the team class...
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
            drivers.add(team.getDriver1());
            drivers.add(team.getDriver2());
        }
        teamLeaderboard.setListData(values.toArray());

        ArrayList<String> driverValues = new ArrayList<>();
        driverValues.add("Points | Driver | Team ID | Experience | Acceleration | Consistency | Cornering");
        for (IDriver driver : drivers) {
            driverValues.add(
                driver.getPoints() + " | " +
                driver.getName() + " | " +
                driver.getTeamID() + " | " +
                driver.getExperience() + " | " +
                driver.getAcceleration() + " | " +
                driver.getConsistency() + " | " +
                driver.getCorner()
            );
        }
        driverLeaderboard.setListData(driverValues.toArray());

        if (currentUser != null) {
            ArrayList<Font> fonts = new ArrayList<>();
            fonts.add(new Font("Comic Sans MS", Font.BOLD, 28));
            //Add more fonts with same size here
            fonts.add(new Font("Arial", Font.BOLD, 28));
            fonts.add(new Font("Times New Roman", Font.BOLD, 28));
            fonts.add(new Font("Verdana", Font.BOLD, 28));
            fonts.add(new Font("Tahoma", Font.BOLD, 28));
            fonts.add(new Font("Calibri", Font.BOLD, 28));
            int randomFont = (int) (Math.random() * fonts.size());

            myTeam.setText(currentUser.getTeam().getName());
            myTeam.setFont(fonts.get(randomFont));
            driver1Text.setText(currentUser.getTeam().getDriver1().getName());
            driver2Text.setText(currentUser.getTeam().getDriver2().getName());
        }

        ActionListener actionListener = event -> {
            IUI chooseTeam = new ChooseTeamUI(formulaOne);
            chooseTeam.updatePane(chooseTeam);
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