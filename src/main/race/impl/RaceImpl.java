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
    private final IQualifier qualifier;
    private IResult raceResult;
    private RaceState state;

    public RaceImpl(int year, ICircuit circuit, ArrayList<ITeam> teams) {
        this.year = year;
        this.circuit = circuit;
        this.teams = teams;
        this.raceResult = null;
        drivers = new ArrayList<>();
        for (ITeam team : getTeams()) {
            drivers.add(team.getDriver1());
            drivers.add(team.getDriver2());
        }
        this.state = RaceState.NOT_STARTED;
        this.qualifier = new QualifierImpl(this, getDrivers());
    }

    @Override
    public void nextAction() {
        if (getState() == RaceState.NOT_STARTED) {
            getQualifier().start();
        } else if (getState() == RaceState.QUALIFIER_FINISHED) {
            startRace();
        } else if (getState() != RaceState.QUALIFIER_STARTED && getState() != RaceState.RACE_STARTED) {
            throw new RuntimeException("Fejl");
            // TODO: Vælg den rigtige exception, evt. custom exception
        }
    }

    private void startRace() {
        if (getState() != RaceState.QUALIFIER_FINISHED) {
            throw new RuntimeException("Fejl");
            // TODO: Vælg den rigtige exception, evt. custom exception: Qualify er ikke færdig
        }

        this.state = RaceState.RACE_STARTED;

        ArrayList<IDriver> gridList = getQualifier().getQualifierResult().asQualifierResult().getGridList();
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

        // TODO: Remove this method, only used for testing
        printResult(raceResult);

        this.state = RaceState.RACE_FINISHED;
    }

    // TODO: Denne metode skal slettes når vi har UI på plads
    private void printResult(IResult result) {
        System.out.println();
        System.out.println(" ===============================");
        System.out.println(" Resultat til " + getCircuit().getName());
        System.out.println(" ===============================");
        for (IDriverResult res : result.getSortedResults()) {
            System.out.println(" " + res.getPlacement() + ": " + res.getDriver().getName() + " - " + res.getPoints() + " : " + res.getTime());
        }
        System.out.println(" ===============================");
        System.out.println(" " + result.asRaceResult().getFastestLap().getDriver().getName() + " satte den hurtigste runde på " + result.asRaceResult().getFastestLap().getTime());
        System.out.println(" ===============================");
        System.out.println();
    }

    @Override
    public void setState(RaceState state) {
        this.state = state;
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
    public IQualifier getQualifier() {
        return this.qualifier;
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