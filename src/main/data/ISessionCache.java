package main.data;

import main.FormulaOne;

import java.util.ArrayList;

public interface ISessionCache {

    int getSaveID();

    ArrayList<ISeason> getSeasons();

    ISeason getCurrentSeason();

    FormulaOne getFormulaOne();

    void setCurrentSeason(ISeason season);

    IUser getCurrentUser();
}