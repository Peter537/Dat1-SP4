package main.race.impl;

import main.data.IDriver;
import main.enums.RaceState;
import main.race.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class QualifierImpl implements IQualifier {

    private final HashMap<IDriver, ILap> fastestLaps = new HashMap<>();
    private final ArrayList<IDriver> drivers;
    private final IRace race;
    private final Random random = new Random();

    private IQualifierResult qualifierResult;

    public QualifierImpl(IRace race, ArrayList<IDriver> drivers) {
        this.race = race;
        this.drivers = drivers;
    }

    @Override
    public void start() {
        if (getRace().getState() != RaceState.NOT_STARTED) {
            throw new RuntimeException("Fejl");
            // TODO: Vælg den rigtige exception, evt. custom exception: Qualify er allerede startet / færdig
        }

        getRace().setState(RaceState.QUALIFIER_STARTED);

        int qualifierLaps = 3;
        for (IDriver driver : getDrivers()) {
            driveLaps(driver, qualifierLaps);
        }

        ArrayList<IDriverResult> results = createDriverResults();

        results.sort((driver1, driver2) -> Float.compare(driver1.getTime(), driver2.getTime()));

        setPlacements(results);

        this.qualifierResult = new QualifierResultImpl(results);

        // TODO: Remove this method, only used for testing
        printResult();

        getRace().setState(RaceState.QUALIFIER_FINISHED);
    }

    private void setPlacements(ArrayList<IDriverResult> results) {
        int i = 1;
        for (IDriverResult result : results) {
            result.setPlacement(i);
            i++;
        }
    }

    private ArrayList<IDriverResult> createDriverResults() {
        ArrayList<IDriverResult> results = new ArrayList<>();
        for (IDriver driver : fastestLaps.keySet()) {
            ArrayList<ILap> lap = new ArrayList<>();
            lap.add(fastestLaps.get(driver));
            results.add(new DriverResultImpl(getRace(), driver, lap, false));
        }
        return results;
    }

    private void driveLaps(IDriver driver, int numberOfLaps) {
        for (int lapNumber = 1; lapNumber <= numberOfLaps; lapNumber++) {
            driveLap(driver, lapNumber);
        }
    }

    private void driveLap(IDriver driver, int lapNumber) {
        float time = random.nextFloat() * 60; // TODO: Change to actual Race algorithm time
        if (!fastestLaps.containsKey(driver)) {
            fastestLaps.put(driver, new LapImpl(getRace(), driver, lapNumber, time));
        } else if (fastestLaps.get(driver).getTime() > time) {
            fastestLaps.put(driver, new LapImpl(getRace(), driver, lapNumber, time));
        }
    }

    // TODO: Denne metode skal slettes når vi har UI på plads
    public void printResult() {
        System.out.println(" =========================");
        System.out.println("Resultat af kvalifikationen:");
        for (IDriverResult result : getQualifierResult().getSortedResults()) {
            System.out.println(result.getDriver().getName() + " - " + result.getTime());
        }
        System.out.println(" =========================");
    }

    @Override
    public IRace getRace() {
        return this.race;
    }

    @Override
    public IQualifierResult getQualifierResult() {
        return this.qualifierResult;
    }

    private ArrayList<IDriver> getDrivers() {
        return this.drivers;
    }
}