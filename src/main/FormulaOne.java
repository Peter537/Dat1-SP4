package main;

import main.data.ISessionCache;
import main.data.impl.SessionCacheImpl;

import javax.swing.*;

public class FormulaOne {

    private final ISessionCache sessionCache;
    private static JFrame page;

    public FormulaOne(String dbPassword) {
        sessionCache = new SessionCacheImpl(this, 1);
        loadDB(dbPassword);
    }

    private void loadDB(String dbPassword) {
        // TODO
    }

    public void run() {
        chooseSaveGame();
        // TODO
    }

    private void chooseSaveGame() {
        // TODO
    }

    public ISessionCache getSessionCache() {
        return this.sessionCache;
    }

    public static JFrame getPage() {
        return FormulaOne.page;
    }
}