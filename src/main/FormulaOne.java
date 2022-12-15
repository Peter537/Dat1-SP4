package main;

import jdk.jshell.spi.ExecutionControl;
import main.data.ISessionCache;
import main.data.impl.SeasonImpl;
import main.data.impl.SessionCacheImpl;
import main.data.impl.UserImpl;
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
        ArrayList<IRace> TESTraces = new ArrayList<>();
        TESTraces.add(new RaceImpl(1, null, sessionCache.getTeams()));
        sessionCache.setCurrentSeason(new SeasonImpl(1, TESTraces , sessionCache.getTeams()));
        IUI menu = new MenuUI(this);
        menu.updatePane(menu);
    }

    private void doClose() {

    }

    public ISessionCache getSessionCache() {
        return this.sessionCache;
    }

    public static JFrame getPage() {
        return FormulaOne.page;
    }
}