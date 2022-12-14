package main.race;

import main.data.IDriver;

import java.util.ArrayList;

public interface IDriverResult {

    IRace getRace();

    IDriver getDriver();

    ArrayList<ILap> getLaps();

    float getTime();

    boolean hasCrashed();

    int getPlacement();

    int getPoints();

    boolean hasFastestLap();

    void setPlacement(int placement);

    void setHasFastestLap(boolean hasFastestLap);

    void setCrashStatus(boolean hasCrashed);

    void addLap(ILap lap);

    boolean isRace();

    boolean isQualifier();

    void addPointsToDriver();
}