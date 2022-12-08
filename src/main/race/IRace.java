package main.race;

public interface IRace {

void nextAction() throws Exception;

void startQualifier();

void startRace();

int id();

ICircuit getCircuit();

IResult getRaceResult();

IResult getQualifierResult();

boolean isFinished();

boolean isStarted();



}