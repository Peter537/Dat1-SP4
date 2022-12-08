package main.data.impl;

import main.FormulaOne;
import main.data.ISeason;
import main.data.ISessionCache;

import java.util.ArrayList;

public class SessionCacheImpl implements ISessionCache {

    private final FormulaOne formulaOne;
    private final int saveID;
    private ArrayList<ISeason> seasons;
    private SeasonImpl season;

    public SessionCacheImpl(FormulaOne formulaOne, int saveID) {
        this.formulaOne = formulaOne;
        this.saveID = saveID;
    }

    @Override
    int getSaveID() {
        return this.saveID;
    }

    @Override
    public ArrayList<ISeason> getSeasons() {
        return this.seasons;
    }
}