package main.ui;

import main.FormulaOne;
import main.data.IDriver;
import main.data.ITeam;
import main.data.IUser;
import main.race.IRace;
import main.race.IResult;

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
    private JList RaceList;
    private JButton DoRace;
    private JScrollPane RaceScrollPane;
    private JLabel RaceListTitle;
    private JLabel driver1Stats;
    private JLabel driver2Stats;
    private JLabel carpng2;
    private FormulaOne formulaOne;
    private IUser currentUser;

    public JPanel getPanel() {
        return MenuPanel;
    }

    public MenuUI(FormulaOne formulaOne) {
        super();
        this.formulaOne = formulaOne;

        if (formulaOne.getSessionCache().getCurrentUser() != null) {
            currentUser = formulaOne.getSessionCache().getCurrentUser();
        }

        setData(this);
    }

    public void setData(MenuUI data) {
        if (formulaOne.getSessionCache() == null)
            throw new NullPointerException("An error has occurred: SessionCache is null and may not have been instantiated.");
        else if (formulaOne.getSessionCache().getCurrentSeason() == null) {
            throw new NullPointerException("An error has occurred: CurrentSeason is null and may not have been instantiated.");
        } else {
            setListData();
            setOnClick();
            setFonts();
        }
    }

    public void getData(MenuUI data) {
    }

    @Override
    public void updatePane(IUI ui) {
        if (formulaOne.getSessionCache().getCurrentUser() == null || currentUser.getTeam() == null) {
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

    private void setListData() {
        ArrayList<ITeam> teams = formulaOne.getSessionCache().getTeams(); //TODO: maybe change to teamleaderboard class
        ArrayList<IDriver> drivers = new ArrayList<>();
        ArrayList<String> values = new ArrayList<>(); //This can also be done with the team class...
        // Add header
//        values.add("Points | Team | Driver 1 | Driver 2 | Car");
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
        drivers.sort((o1, o2) -> o2.getPoints() - o1.getPoints());

        ArrayList<String> driverValues = new ArrayList<>();
//        driverValues.add("Points | Driver | Team Name | Experience | Acceleration | Consistency | Cornering");
        for (IDriver driver : drivers) {
            driverValues.add(
                    driver.getPoints() + " | " +
                            driver.getName() + " | " +
                            driver.getTeam().getName() + " | " +
                            driver.getExperience() + " | " +
                            driver.getAcceleration() + " | " +
                            driver.getConsistency() + " | " +
                            driver.getCorner()
            );
        }
        driverLeaderboard.setListData(driverValues.toArray());

        ArrayList<IRace> races = formulaOne.getSessionCache().getCurrentSeason().getRaces();
        ArrayList<IResult> results = new ArrayList<>();
        for (IRace race : races) {
            results.add(race.getResult());
        }

//        for (IResult result : results) {
//
//        }
        if (results.isEmpty() || results.get(0) == null) {
            String[] noraces = {"No races have been completed yet."};
            RaceList.setListData(noraces);
        }
        else {
            RaceList.setListData(results.toArray());
        }
    }

    private void setOnClick() {
        teamLeaderboard.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // Get the selected item and display a message
                String selectedItem = (String) teamLeaderboard.getSelectedValue();
                ITeam selectedTeam = formulaOne.getSessionCache().getTeams().get(teamLeaderboard.getSelectedIndex());
                JOptionPane.showMessageDialog(null, "You selected: " +
                        selectedTeam.getName() + ".\n" +
                        "They currently have " + selectedTeam.getPoints() + " points.\n" +
                        "Their drivers are " + selectedTeam.getDriver1().getName() + " and " + selectedTeam.getDriver2().getName() + ".\n" +
                        "Their car is a " + selectedTeam.getCar().getName() + ".\n"
                        );
                System.out.println(selectedItem);
            }
        });

        ActionListener actionListener = event -> {
            IUI chooseTeam = new ChooseTeamUI(formulaOne);
            chooseTeam.updatePane(chooseTeam);
        };
        changeTeamButton.addActionListener(actionListener);

        ActionListener actionListener1 = e -> {
            if (formulaOne.getSessionCache().getCurrentSeason().hasNextAction()) {
                formulaOne.getSessionCache().getCurrentSeason().nextAction();
                IUI updateMenu = new MenuUI(formulaOne);
                updateMenu.updatePane(updateMenu);
            }
            else
                JOptionPane.showMessageDialog(null, "The season has ended.");
        };
        DoRace.addActionListener(actionListener1);
    }
    private void setFonts() {
        if (currentUser != null) {
            ArrayList<Font> fonts = new ArrayList<>();
            fonts.add(new Font("Comic Sans MS", Font.BOLD, 28));
            //Add more fonts with same size here
            fonts.add(new Font("Arial", Font.BOLD, 28));
            fonts.add(new Font("Times New Roman", Font.BOLD, 28));
            fonts.add(new Font("Verdana", Font.BOLD, 28));
            fonts.add(new Font("Tahoma", Font.BOLD, 28));
            fonts.add(new Font("Calibri", Font.BOLD, 28));

            ArrayList<Font> smallfonts = new ArrayList<>();
            smallfonts.add(new Font("Comic Sans MS", Font.PLAIN, 12));
            smallfonts.add(new Font("Arial", Font.PLAIN, 12));
            smallfonts.add(new Font("Times New Roman", Font.PLAIN, 12));
            smallfonts.add(new Font("Verdana", Font.PLAIN, 12));
            smallfonts.add(new Font("Tahoma", Font.PLAIN, 12));
            smallfonts.add(new Font("Calibri", Font.PLAIN, 12));

            RaceListTitle.setFont(fonts.get((int) (Math.random() * fonts.size())));

            if (currentUser.getTeam() != null) {
                myTeam.setText(currentUser.getTeam().getName());
                if (currentUser.getTeam().getName().contains("Gabe"))
                    myTeam.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
                else
                    myTeam.setFont(fonts.get((int) (Math.random() * fonts.size())));

                IDriver driver1 = currentUser.getTeam().getDriver1();
                driver1Text.setText(driver1.getName());
                driver1Text.setFont(fonts.get((int) (Math.random() * fonts.size())));
                driver1Stats.setText("Current Points: " + driver1.getPoints() + " | " +
                        "Experience: " + driver1.getExperience() + " | " +
                        "Acceleration: " + driver1.getAcceleration() + " | " +
                        "Consistency: " + driver1.getConsistency() + " | " +
                        "Cornering: " + driver1.getCorner()
                );
                driver1Stats.setFont(smallfonts.get((int) (Math.random() * smallfonts.size())));

                IDriver driver2 = currentUser.getTeam().getDriver2();
                driver2Text.setText(driver2.getName());
                driver2Text.setFont(fonts.get((int) (Math.random() * fonts.size())));
                driver2Stats.setText("Current Points: " + driver2.getPoints() + " | " +
                        "Experience: " + driver2.getExperience() + " | " +
                        "Acceleration: " + driver2.getAcceleration() + " | " +
                        "Consistency: " + driver2.getConsistency() + " | " +
                        "Cornering: " + driver2.getCorner()
                );
                driver2Stats.setFont(smallfonts.get((int) (Math.random() * smallfonts.size())));

                driverLeaderboard.setFont(smallfonts.get((int) (Math.random() * smallfonts.size())));
                teamLeaderboard.setFont(smallfonts.get((int) (Math.random() * smallfonts.size())));
            }
        }
    }

    public boolean isModified(MenuUI data) {
        return false;
    }
}