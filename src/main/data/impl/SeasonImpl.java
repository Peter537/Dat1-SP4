package main.data.impl;

import main.data.*;
import main.enums.Action;
import main.enums.RaceState;
import main.race.IRace;

import java.util.ArrayList;

public class SeasonImpl implements ISeason {

    private final int year;
    private final ArrayList<IRace> races;
    private final ArrayList<ITeam> teams;
    private final ITeamLeaderboard teamLeaderboard;
    private final IDriverLeaderboard driverLeaderboard;
    private IRace currentRace;

    public SeasonImpl(int year, ArrayList<IRace> races, ArrayList<ITeam> teams) {
        this.year = year;
        this.races = races;
        this.teams = teams;
        this.currentRace = races.get(0);
        this.teamLeaderboard = new TeamLeaderboardImpl(getTeams());
        ArrayList<IDriver> drivers = new ArrayList<>();
        for (ITeam team : getTeams()) {
            drivers.add(team.getDriver1());
            drivers.add(team.getDriver2());
        }
        this.driverLeaderboard = new DriverLeaderboardImpl(drivers);
    }

    @Override
    public Action nextAction() {
        if (!(getCurrentRace().getState() == RaceState.NOT_STARTED) && !(getCurrentRace().getState() == RaceState.QUALIFIER_FINISHED)) {
            if (getCurrentRace().getState() != RaceState.RACE_FINISHED) return Action.RACE_NOT_FINISHED;
            for (IRace race : getRaces()) {
                if (race.getState() == RaceState.NOT_STARTED) {
                    setCurrentRace(race);
                    break;
                }
            }
            if (!hasNextAction()) {
                return Action.SEASON_FINISHED;
            }
        }

        getCurrentRace().nextAction();
        updateLeaderboards();
        return Action.COMPLETE;
    }

    @Override
    public void updateLeaderboards() {
        getTeamLeaderboard().update();
        getDriverLeaderboard().update();
    }

    @Override
    public boolean hasNextAction() {
        return getCurrentRace() != null;
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

    @Override
    public IRace getCurrentRace() {
        return this.currentRace;
    }

    @Override
    public void setCurrentRace(IRace currentRace) {
        this.currentRace = currentRace;
    }

    @Override
    public String toString() {
        return "SeasonImpl{" +
                "year=" + getYear() +
                ", races=" + getRaces() +
                ", teams=" + getTeams() +
                ", teamLeaderboard=" + getTeamLeaderboard() +
                ", driverLeaderboard=" + getDriverLeaderboard() +
                ", currentRace=" + getCurrentRace() +
                '}';
    }
}