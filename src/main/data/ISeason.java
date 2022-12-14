package main.data;

import main.enums.Action;
import main.race.IRace;

import java.util.ArrayList;

public interface ISeason {

    Action nextAction();

    void updateLeaderboards();

    boolean hasNextAction();

    int getYear();

    ArrayList<IRace> getRaces();

    ArrayList<ITeam> getTeams();

    ITeamLeaderboard getTeamLeaderboard();

    IDriverLeaderboard getDriverLeaderboard();

    IRace getCurrentRace();

    void setCurrentRace(IRace currentRace);

    void setTeams(ArrayList<ITeam> teams);
}