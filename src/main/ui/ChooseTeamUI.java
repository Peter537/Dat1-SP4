package main.ui;

import main.FormulaOne;
import main.data.ITeam;
import main.data.ITeamLeaderboard;
import main.data.impl.UserImpl;
import main.database.DataBaseIO;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ChooseTeamUI extends AUI {
    private final Object formulaOne;
    private JPanel ChooseTeam;
    private JList teamList;
    private JScrollPane scrollPane;
    private JLabel title;

    public JPanel getPanel() {
        return ChooseTeam;
    }

    public ChooseTeamUI(FormulaOne formulaOne) {
        super();

        this.formulaOne = formulaOne;

        teamList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // Get the selected item and display a message
                ITeam selectedItem = (ITeam) teamList.getSelectedValue();
                JOptionPane.showMessageDialog(null, "You selected: " + selectedItem.getName());
                System.out.println(selectedItem.getName());
                if (formulaOne.getSessionCache().getCurrentUser() == null)
                    formulaOne.getSessionCache().setCurrentUser(new UserImpl(selectedItem));
                else
                    formulaOne.getSessionCache().getCurrentUser().setTeam(selectedItem);
                IUI menu = new MenuUI(formulaOne);
                menu.updatePane(menu);
            }
        });

        setData(this);
    }

    public void setData(ChooseTeamUI data) {
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

        teamList.setListData(teams.toArray());
    }

    public void getData(ChooseTeamUI data) {
    }
}
