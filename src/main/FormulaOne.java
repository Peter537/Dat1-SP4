package main;

import main.data.ISessionCache;
import main.data.impl.SessionCacheImpl;
import main.database.DataBaseIO;

import javax.swing.*;
import javax.xml.crypto.Data;

public class FormulaOne {

    private final ISessionCache sessionCache;
    private static JFrame page;

    public FormulaOne() {
        this.sessionCache = new SessionCacheImpl(this, 1);
    }

    private void loadDB() {
        DataBaseIO.initSQL(true, this); //TODO: Make 'isNewSave' variable
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