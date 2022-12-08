package main.race.impl;

import main.data.ICircuit;
import main.race.IRace;
import main.race.IRaceResult;

public class RaceImpl implements IRace {

private final int id;
private final ICircuit circuit;
private IRaceResult raceResult;
private IRaceResult qualifierResult;

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
    public IRace getRace() {
        return RaceImpl.this;
    }

    public int getId() {
        return id;
    }

    public ICircuit getCircuit() {
        return circuit;
    }

    public IRaceResult getRaceResult() {
        return raceResult;
    }

    public IRaceResult getQualifierResult() {
        return qualifierResult;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public boolean isStarted() {
        return isStarted;
    }
}