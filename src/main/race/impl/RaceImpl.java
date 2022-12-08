package main.race.impl;

import main.race.ICircuit;
import main.race.IRace;
import main.race.IResult;

public class RaceImpl implements IRace {

    private final int id;
    private final ICircuit circuit;
    private IResult raceResult;
    private IResult qualifierResult;
    private boolean isFinished;
    private boolean isStarted;

    public RaceImpl(int id, ICircuit circuit) {
        this.id = id;
        this.circuit = circuit;
    }

    @Override
    public void nextAction() throws Exception {
       // TODO: Flesh out this method
    }

    private void startQualifier() {
        // TODO: Flesh out this method
    }

    private void startRace() {
        // TODO: Flesh out this method
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

    @Override
    public boolean isFinished() {
        return this.isFinished;
    }

    @Override
    public boolean isStarted() {
        return this.isStarted;
    }
}