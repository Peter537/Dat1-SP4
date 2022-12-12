package main.race;

import main.enums.RaceState;

import java.util.ArrayList;

public interface IRace {

    void nextAction();

    int getYear();

    ICircuit getCircuit();

    IResult getRaceResult();

    IResult getQualifierResult();

    RaceState getState();
}