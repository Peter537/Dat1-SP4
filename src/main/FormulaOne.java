package main;

import jdk.jshell.spi.ExecutionControl;
import main.data.ICar;
import main.data.IDriver;
import main.data.ISessionCache;
import main.data.ITeam;
import main.data.impl.*;
import main.database.DataBaseIO;
import main.race.IRace;
import main.race.impl.RaceImpl;
import main.ui.*;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;

public class FormulaOne {

    private final ISessionCache sessionCache;
    private static JFrame page;

    public FormulaOne() {
        this.sessionCache = new SessionCacheImpl(this, 1);
        this.sessionCache.setCurrentUser(new UserImpl(null));
        loadDB();
    }

    private void loadDB() {
        DataBaseIO.initSQL(true, this); //TODO: Make 'isNewSave' variable
        this.sessionCache.setTeams(DataBaseIO.loadDefaultTeamData());
    }

    public void run() {
        chooseSaveGame();
        initUI();
        // TODO
    }

    private void chooseSaveGame() {
        // TODO: Make a UI for this
    }

    private void initUI() {
        page = new JFrame("Formula One");
        page.setMinimumSize(new Dimension(750, 750));
        page.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        page.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.out.println("Saving data...");
                DataBaseIO.saveData();
                System.out.println("Data saved!");
                System.exit(0);
                System.exit(0);
                e.getWindow().dispose();
            }
        });
        page.pack();
        page.setVisible(true);
        IUI menu = new MenuUI(this);
        menu.updatePane(menu);
    }

//    private void makeRandomData() {
//        ArrayList<ITeam> teams = new ArrayList<>();
//        java.util.Random r = new java.util.Random();
//
//        for (int i = 1; i <= 10; i++) {
//            ICar car = new CarImpl(i, "car" + i, r.nextInt(50) + 1000, r.nextInt(50) + 1000, r.nextDouble(0.1) + 0.1, r.nextDouble(0.1) + 0.1);
//            IDriver driver1 = new DriverImpl(i * 2 - 1, "driver" + (i * 2 - 1), 1, 1, 1, 1);
//            IDriver driver2 = new DriverImpl(i * 2, "driver" + (i * 2), 1, 1, 1, 1);
//            ITeam newteam = new TeamImpl(i, "team" + i, car, driver1, driver2);
//            teams.add(newteam);
//            driver1.setTeam(newteam);
//            driver2.setTeam(newteam);
//            System.out.println(car.getAerodynamics() + " " + car.getName() + " " + car.getWeight() + " " + car.getID() + " " + car.getHorsePower() + " " + car.getTraction());
//        }
//
//        sessionCache.setTeams(teams);
//    }

    public ISessionCache getSessionCache() {
        return this.sessionCache;
    }

    public static JFrame getPage() {
        return FormulaOne.page;
    }
}