package main.data.impl;

import main.data.ISeason;
import main.data.ITeam;
import main.race.IRace;
import main.utils.DriverLeaderboard;
import main.utils.TeamLeaderboard;

import java.util.ArrayList;

public class SeasonImpl implements ISeason {
private final int year;
private final ArrayList<IRace> races;
private final ArrayList<ITeam> teams;
private final ITeamLeaderboard teamLeaderboard;
private final IDriverLeaderboard driverLeaderboard;


    public SeasonImpl(int year, ArrayList<IRace> races, ArrayList<ITeam> teams, ITeamLeaderboard teamLeaderboard, IDriverLeaderboard driverLeaderboard) {
        this.year = year;
        this.races = races;
        this.teams = teams;
        this.teamLeaderboard = teamLeaderboard;
        this.driverLeaderboard = driverLeaderboard;
    }
    // TODO: finish this class with the bottompart of UML scheme (of the Season class)
}