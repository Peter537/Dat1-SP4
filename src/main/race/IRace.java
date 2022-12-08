package main.race;

import java.util.ArrayList;

public interface IRace {

    void nextAction();

    int getID();

    ICircuit getCircuit();

    IResult getRaceResult();

    IResult getQualifierResult();

    boolean isFinished();

    boolean isStarted();
}