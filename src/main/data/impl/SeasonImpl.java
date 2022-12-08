package main.data.impl;

import main.data.IDriverLeaderboard;
import main.data.ISeason;
import main.data.ITeam;
import main.data.ITeamLeaderboard;
import main.race.IRace;

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

    @Override
    public boolean nextAction() {
        return false;
    }

    @Override
    public boolean hasNextAction() {
        return false;
    }

    @Override
    public int getYear() {
        return this.year;
    }

    @Override
    public ArrayList<IRace> getRaces() {
        return this.races;
    }

    @Override
    public ArrayList<ITeam> getTeams() {
        return this.teams;
    }

    @Override
    public ITeamLeaderboard getTeamLeaderboard() {
        return this.teamLeaderboard;
    }

    @Override
    public IDriverLeaderboard getDriverLeaderboard() {
        return this.driverLeaderboard;
    }
}