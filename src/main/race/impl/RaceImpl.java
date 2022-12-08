package main.race.impl;

import main.enums.RaceState;
import main.race.ICircuit;
import main.race.IRace;
import main.race.IResult;

public class RaceImpl implements IRace {

    private final int id;
    private final ICircuit circuit;
    private IResult raceResult;
    private IResult qualifierResult;
    private RaceState state;

    public RaceImpl(int id, ICircuit circuit) {
        this.id = id;
        this.circuit = circuit;
        this.raceResult = null;
        this.qualifierResult = null;
        this.state = RaceState.NOT_STARTED;
    }

    @Override
    public void nextAction() {
        if (getState() == RaceState.NOT_STARTED) {
            startQualifier();
            return;
        } else if (getState() == RaceState.QUALIFIER_FINISHED) {
            startRace();
        } else if (getState() == RaceState.QUALIFIER_STARTED || getState() == RaceState.RACE_STARTED) {
            return;
        }
        throw new RuntimeException("Fejl");
        // TODO: Vælg den rigtige exception, evt. custom exception
    }

    private void startQualifier() {
        this.state = RaceState.QUALIFIER_STARTED;

        // TODO: Flesh out this method
        System.out.println("qualifier");

        this.state = RaceState.QUALIFIER_FINISHED;
    }

    private void startRace() {
        this.state = RaceState.RACE_STARTED;

        // TODO: Flesh out this method
        System.out.println("race");

        this.state = RaceState.RACE_FINISHED;
    }

    @Override
    public int getID() {
        return this.id;
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

    // Todo: Add to interface
    public RaceState getState() {
        return this.state;
    }

    @Override
    public boolean isFinished() {
        return false;
        // TODO: Remove this method
    }

    @Override
    public boolean isStarted() {
        return false;
        // TODO: Remove this method
    }
}