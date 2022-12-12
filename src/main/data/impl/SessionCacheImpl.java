package main.data.impl;

import main.FormulaOne;
import main.data.ISeason;
import main.data.ISessionCache;

import java.util.ArrayList;

public class SessionCacheImpl implements ISessionCache {

    private final FormulaOne formulaOne;
    private final int saveID;
    private final ArrayList<ISeason> seasons; // TODO: Maybe add constructor parameter to this? Vi skal jo have data ud fra databasen
    private ISeason currentSeason;

    public SessionCacheImpl(FormulaOne formulaOne, int saveID) {
        this.formulaOne = formulaOne;
        this.saveID = saveID;
        this.seasons = new ArrayList<>();
        this.currentSeason = null;
    }

    @Override
    public int getSaveID() {
        return this.saveID;
    }

    @Override
    public ArrayList<ISeason> getSeasons() {
        return this.seasons;
    }

    @Override
    public ISeason getCurrentSeason() {
        return this.currentSeason;
    }

    @Override
    public FormulaOne getFormulaOne() {
        return this.formulaOne;
    }

    @Override
    public void setCurrentSeason(ISeason currentSeason) {
        this.currentSeason = currentSeason;
    }
}