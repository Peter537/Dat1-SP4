package main.race.impl;

import main.data.ICircuit;
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


    public int getID() {
        return this.id;
    }

    public ICircuit getCircuit() {
        return this.circuit;
    }

    public IResult getRaceResult() {
        return this.raceResult;
    }

    public IResult getQualifierResult() {
        return this.qualifierResult;
    }

    public boolean isFinished() {
        return this.isFinished;
    }

    public boolean isStarted() {
        return this.isStarted;
    }
}