package main.race.impl;

import main.data.ICar;
import main.data.IDriver;
import main.data.ITeam;
import main.enums.RaceState;
import main.race.*;
import main.race.circuit.CircuitComponentCornerImpl;
import main.race.circuit.ICircuitComponent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RaceImpl implements IRace {

    private final Random random = new Random();
    private final int year;
    private final ICircuit circuit;
    private final ArrayList<ITeam> teams;
    private final ArrayList<IDriver> drivers;
    private final IQualifier qualifier;
    private final HashMap<IDriver, ICar> driverCarMap = new HashMap<>();
    private final HashMap<IDriver, Double> driverCurrentSpeedMap = new HashMap<>();

    private IResult result;
    private RaceState state;

    public RaceImpl(int year, ICircuit circuit, ArrayList<ITeam> teams) {
        this.year = year;
        this.circuit = circuit;
        this.teams = teams;
        this.result = null;
        drivers = new ArrayList<>();
        for (ITeam team : getTeams()) {
            drivers.add(team.getDriver1());
            drivers.add(team.getDriver2());
            driverCarMap.put(team.getDriver1(), team.getCar());
            driverCarMap.put(team.getDriver2(), team.getCar());
            driverCurrentSpeedMap.put(team.getDriver1(), 0.0);
            driverCurrentSpeedMap.put(team.getDriver2(), 0.0);
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

        ArrayList<IDriver> gridList = getQualifier().getResult().asQualifierResult().getGridList();
        ArrayList<IDriverResult> results = createDriverResults(gridList);
        ILap fastestLap = null;

        for (int lap = 1; lap <= getCircuit().getLaps(); lap++) {
            fastestLap = driveLap(lap, results, fastestLap);
        }

        sortDriverResults(results);
        setPlacements(results);

        for (IDriverResult result : results) {
            result.setHasFastestLap(fastestLap != null && fastestLap.getDriver().equals(result.getDriver()));
            result.addPointsToDriver();
        }

        this.result = new RaceResultImpl(results, fastestLap);

        // TODO: Remove this method, only used for testing
        printResult();

        this.state = RaceState.RACE_FINISHED;
    }

    private ILap driveLap(int lap, ArrayList<IDriverResult> results, ILap fastestLap) {
        System.out.println(" Lap: " + lap);
        for (IDriverResult result : results) {
            if (result.hasCrashed()) {
                continue;
            } else if (crashesThisLap(result)) {
                System.out.println(" " + result.getDriver().getName() + " er ude af løbet"); // TODO: Remove this debug message
                continue;
            }

            ILap l = new LapImpl(this, result.getDriver(), lap, getLapTime(result.getDriver()));
            result.addLap(l);
            fastestLap = getFastestLap(fastestLap, l);
        }
        return fastestLap;
    }

    @Override
    public float getLapTime(IDriver driver) {
        if (getCircuit().getComponents().isEmpty()) {
            // TODO: Add actual lap time calculation
            return random.nextFloat() * 60;
        }

        ICar car = getDriverCarMap().get(driver);

        IRaceAlgorithm algorithmCorner = new RaceAlgorithmCornerImpl();
        IRaceAlgorithm algorithmStraight = new RaceAlgorithmStraightImpl();

        float time = 0f;
        for (ICircuitComponent component : getCircuit().getComponents()) {
            if (component instanceof CircuitComponentCornerImpl) { // TODO: Use interface instead of Impl (need to be created)
                time += algorithmCorner.getTime(this, driver, car, component, driverCurrentSpeedMap.get(driver));
            } else {
                time += algorithmStraight.getTime(this, driver, car, component, driverCurrentSpeedMap.get(driver));
            }
        }

        return time;
    }

    private boolean crashesThisLap(IDriverResult result) {
        // TODO: Add the actual crash algorithm
        if (random.nextDouble() < 0.0018) {
            result.setHasCrashed(true);
            return true;
        }
        return false;
    }

    private ILap getFastestLap(ILap fastestLap, ILap newLap) {
        if (fastestLap == null || fastestLap.getTime() > newLap.getTime()) {
            fastestLap = newLap;
        }
        return fastestLap;
    }

    private void setPlacements(ArrayList<IDriverResult> results) {
        int i = 1;
        for (IDriverResult result : results) {
            if (result.hasCrashed()) {
                result.setPlacement(20);
            } else {
                result.setPlacement(i);
                i++;
            }
        }
    }

    private void sortDriverResults(ArrayList<IDriverResult> results) {
        results.sort((driver1, driver2) -> {
            if (driver1.getLaps().size() < driver2.getLaps().size()) {
                return 1;
            } else if (driver1.getLaps().size() > driver2.getLaps().size()) {
                return -1;
            } else {
                return Float.compare(driver1.getTime(), driver2.getTime());
            }
        });
    }

    private ArrayList<IDriverResult> createDriverResults(ArrayList<IDriver> gridList) {
        ArrayList<IDriverResult> results = new ArrayList<>();
        for (IDriver driver : gridList) {
            results.add(new DriverResultImpl(this, driver, new ArrayList<>(), true));
        }
        return results;
    }

    // TODO: Denne metode skal slettes når vi har UI på plads
    private void printResult() {
        System.out.println();
        System.out.println(" ===============================");
        System.out.println(" Resultat til " + getCircuit().getName());
        System.out.println(" ===============================");
        for (IDriverResult res : getResult().getSortedResults()) {
            System.out.println(" " + res.getPlacement() + ": " + res.getDriver().getName() + " - " + res.getPoints() + " : " + res.getTime());
        }
        System.out.println(" ===============================");
        System.out.println(" " + getResult().asRaceResult().getFastestLap().getDriver().getName() + " satte den hurtigste runde på " + getResult().asRaceResult().getFastestLap().getTime());
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
    public IResult getResult() {
        return this.result;
    }

    @Override
    public IQualifier getQualifier() {
        return this.qualifier;
    }

    @Override
    public RaceState getState() {
        return this.state;
    }

    @Override
    public void setNewSpeed(IDriver driver, double speed) {
        driverCurrentSpeedMap.put(driver, speed);
    }

    private ArrayList<ITeam> getTeams() {
        return this.teams;
    }

    private ArrayList<IDriver> getDrivers() {
        return this.drivers;
    }

    private HashMap<IDriver, ICar> getDriverCarMap() {
        return this.driverCarMap;
    }
}