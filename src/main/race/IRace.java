package main.race;

import main.data.IDriver;
import main.enums.RaceState;
import main.enums.WeatherCondition;

public interface IRace {

    void nextAction();

    void setState(RaceState state);

    float getLapTime(IDriver driver);

    void setNewSpeed(IDriver driver, double speed);

    int getYear();

    ICircuit getCircuit();

    IResult getResult();

    IQualifier getQualifier();

    RaceState getState();

    WeatherCondition getWeatherCondition();
}