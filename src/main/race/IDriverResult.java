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
}