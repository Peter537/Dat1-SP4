package main.data;

import main.FormulaOne;

import java.util.ArrayList;

public interface ISessionCache {

    int getSaveID();

    ArrayList<ISeason> getSeasons();

    ISeason getCurrentSeason();

    FormulaOne getFormulaOne();

    void setCurrentSeason(ISeason season);

    ArrayList<ITeam> getTeams();

    void setTeams(ArrayList<ITeam> teams);

    IUser getCurrentUser();

    void setCurrentUser(IUser user);
}