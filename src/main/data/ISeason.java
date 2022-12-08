package main.data;

import main.race.IRace;

import java.util.ArrayList;

public interface ISeason {

    boolean nextAction();

    boolean hasNextAction();

    int getYear();

    ArrayList<IRace> getRaces();

    ArrayList<ITeam> getTeams();

    ITeamLeaderboard getTeamLeaderboard();

    IDriverLeaderboard getDriverLeaderboard();
}