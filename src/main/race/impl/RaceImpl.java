package main.race.impl;

import main.data.IDriver;
import main.data.ITeam;
import main.enums.RaceState;
import main.race.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RaceImpl implements IRace {

    private final int year;
    private final ICircuit circuit;
    private final ArrayList<ITeam> teams;
    private final ArrayList<IDriver> drivers;
    private IResult raceResult;
    private IResult qualifierResult;
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
        } else if (getState() == RaceState.QUALIFIER_FINISHED) {
            startRace();
        } else if (getState() != RaceState.QUALIFIER_STARTED && getState() != RaceState.RACE_STARTED) {
            throw new RuntimeException("Fejl");
            // TODO: Vælg den rigtige exception, evt. custom exception
        }
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
            for (int i = 1; i <= 3; i++) { // Everyone gets 3 laps during qualifier
                float time = random.nextFloat() * 60; // TODO: Change to actual Race algorithm time
                if (!fastestLaps.containsKey(driver)) {
                    fastestLaps.put(driver, new LapImpl(this, driver, i, time));
                } else if (fastestLaps.get(driver).getTime() > time) {
                    fastestLaps.put(driver, new LapImpl(this, driver, i, time));
                }
            }
        }

        ArrayList<IDriverResult> results = new ArrayList<>();
        for (IDriver driver : fastestLaps.keySet()) {
            ArrayList<ILap> lap = new ArrayList<>();
            lap.add(fastestLaps.get(driver));
            results.add(new DriverResultImpl(this, driver, lap, false));
        }

        results.sort((driver1, driver2) -> Float.compare(driver1.getTime(), driver2.getTime()));

        int i = 1;
        for (IDriverResult result : results) {
            result.setPlacement(i);
            i++;
        }

        this.qualifierResult = new QualifierResultImpl(results);

        // TODO: Remove these print statements
        System.out.println();
        System.out.println(" Kvalifikation til " + getCircuit().getName());
        System.out.println(" ===============================");
        for (IDriverResult result : getQualifierResult().getSortedResults()) {
            System.out.println(" " + result.getDriver().getName() + " - " + result.getLaps().get(0).getTime());
        }
        System.out.println(" ===============================");
        System.out.println();

        this.state = RaceState.QUALIFIER_FINISHED;
    }

    private void startRace() {
        if (getState() != RaceState.QUALIFIER_FINISHED) {
            throw new RuntimeException("Fejl");
            // TODO: Vælg den rigtige exception, evt. custom exception: Qualify er ikke færdig
        }

        this.state = RaceState.RACE_STARTED;

        ArrayList<IDriver> gridList = getQualifierResult().asQualifierResult().getGridList();
        ArrayList<IDriverResult> results = new ArrayList<>();
        for (IDriver driver : gridList) {
            results.add(new DriverResultImpl(this, driver, new ArrayList<>(), true));
        }
        ILap fastestLap = null;

        Random random = new Random();
        for (int lap = 1; lap <= getCircuit().getLaps(); lap++) {
            System.out.println(" Lap: " + lap);
            for (IDriverResult result : results) {
                if (random.nextDouble() < 0.0018) { // TODO: Add the actual crash algorithm
                    System.out.println(" " + result.getDriver().getName() + " er ude af løbet"); // TODO: Remove this debug message
                    result.setHasCrashed(true);
                }
                if (result.hasCrashed()) {
                    continue;
                }

                ILap l = new LapImpl(this, result.getDriver(), lap, random.nextFloat() * 60);
                result.addLap(l);
                if (fastestLap == null || fastestLap.getTime() > l.getTime()) {
                    fastestLap = l;
                }
            }
        }

        results.sort((driver1, driver2) -> {
            if (driver1.getLaps().size() < driver2.getLaps().size()) {
                return 1;
            } else if (driver1.getLaps().size() > driver2.getLaps().size()) {
                return -1;
            } else {
                return Float.compare(driver1.getTime(), driver2.getTime());
            }
        });

        int i = 1;
        for (IDriverResult result : results) {
            if (result.hasCrashed()) {
                result.setPlacement(20);
            } else {
                result.setPlacement(i);
                i++;
            }
        }

        for (IDriverResult result : results) {
            result.setHasFastestLap(fastestLap != null && fastestLap.getDriver().equals(result.getDriver()));
            result.addPointsToDriver();
        }

        this.raceResult = new RaceResultImpl(results, fastestLap);

        // TODO: Remove these print statements
        System.out.println();
        System.out.println(" Løb til " + getCircuit().getName());
        System.out.println(" ===============================");
        for (IDriverResult result : getRaceResult().getSortedResults()) {
            System.out.println(" " + result.getPlacement() + ": " + result.getDriver().getName() + " - " + result.getPoints() + " : " + result.getTime());
        }
        System.out.println(" ===============================");
        System.out.println(" " + getRaceResult().asRaceResult().getFastestLap().getDriver().getName() + " satte den hurtigste runde på " + getRaceResult().asRaceResult().getFastestLap().getTime());
        System.out.println(" ===============================");
        System.out.println();

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