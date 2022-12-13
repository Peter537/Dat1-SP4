package main.race;

import main.enums.RaceState;

public interface IRace {

    void nextAction();

    void setState(RaceState state);

    float getLapTime();

    int getYear();

    ICircuit getCircuit();

    IResult getRaceResult();

    IQualifier getQualifier();

    RaceState getState();
}