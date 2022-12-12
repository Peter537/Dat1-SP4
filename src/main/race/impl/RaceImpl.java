package main.race.impl;

import main.data.IDriver;
import main.data.ITeam;
import main.enums.RaceState;
import main.race.*;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RaceImpl implements IRace {

    private final int year;
    private final ICircuit circuit;
    private final ArrayList<ITeam> teams;
    private final ArrayList<IDriver> drivers;
    private final IResult raceResult;
    private final IResult qualifierResult;
    private RaceState state;

    public RaceImpl(int year, ICircuit circuit, ArrayList<ITeam> teams) {
        this.year = year;
        this.circuit = circuit;
        this.teams = teams;
        this.raceResult = null;
        this.qualifierResult = null;
        drivers = new ArrayList<>();
        for (ITeam team : getTeams()) {
            drivers.add(team.getDriver1());
            drivers.add(team.getDriver2());
        }
        this.state = RaceState.NOT_STARTED;
    }

    @Override
    public void nextAction() {
        if (getState() == RaceState.NOT_STARTED) {
            startQualifier();
            return;
        } else if (getState() == RaceState.QUALIFIER_FINISHED) {
            startRace();
            return;
        } else if (getState() == RaceState.QUALIFIER_STARTED || getState() == RaceState.RACE_STARTED) {
            return;
        }
        throw new RuntimeException("Fejl");
        // TODO: Vælg den rigtige exception, evt. custom exception
    }

    private void startQualifier() {
        if (getState() != RaceState.NOT_STARTED) {
            throw new RuntimeException("Fejl");
            // TODO: Vælg den rigtige exception, evt. custom exception: Qualify er allerede startet / færdig
        }

        this.state = RaceState.QUALIFIER_STARTED;

        HashMap<IDriver, ILap> fastestLaps = new HashMap<>();
        Random random = new Random();
        for (IDriver driver : getDrivers()) {
            for (int i = 0; i < 3; i++) {
                float time = random.nextFloat() * 60; // TODO: Change to actual Race algorithm time
                if (fastestLaps.containsKey(driver)) {
                    if (fastestLaps.get(driver).getTime() > time) {
                        fastestLaps.put(driver, new LapImpl(this, driver, i, time));
                    }
                } else {
                    fastestLaps.put(driver, new LapImpl(this, driver, i, time));
                }
            }
        }

        ArrayList<IDriverResult> results = new ArrayList<>();
        for (IDriver driver : fastestLaps.keySet()) {
            ArrayList<ILap> lap = new ArrayList<>();
            lap.add(fastestLaps.get(driver));
            results.add(new DriverResultImpl(this, driver, lap));
        }


        // TODO: Flesh out this method
        System.out.println("qualifier");

        this.state = RaceState.QUALIFIER_FINISHED;
    }

    private void startRace() {
        if (getState() != RaceState.QUALIFIER_FINISHED) {
            throw new RuntimeException("Fejl");
            // TODO: Vælg den rigtige exception, evt. custom exception: Qualify er ikke færdig
        }

        this.state = RaceState.RACE_STARTED;

        // TODO: Flesh out this method
        System.out.println("race");

        this.state = RaceState.RACE_FINISHED;
    }

    @Override
    public int getYear() {
        return this.year;
    }

    @Override
    public ICircuit getCircuit() {
        return this.circuit;
    }

    @Override
    public IResult getRaceResult() {
        return this.raceResult;
    }

    @Override
    public IResult getQualifierResult() {
        return this.qualifierResult;
    }

    @Override
    public RaceState getState() {
        return this.state;
    }

    private ArrayList<ITeam> getTeams() {
        return this.teams;
    }

    private ArrayList<IDriver> getDrivers() {
        return this.drivers;
    }
}