package main.race.impl;

import main.data.IDriver;
import main.race.IDriverResult;
import main.race.ILap;
import main.race.IRace;

import java.util.ArrayList;

public class DriverResultImpl implements IDriverResult {

    private final IRace race;
    private final IDriver driver;
    private final ArrayList<ILap> laps;

    private float time;
    private boolean hasCrashed;

    private int placement;
    private int points;
    private boolean hasFastestLap;

    public DriverResultImpl(IRace race, IDriver driver, ArrayList<ILap> laps) {
        this.race = race;
        this.driver = driver;
        this.laps = laps;
    }

    @Override
    public IRace getRace() {
        return race;
    }

    public IDriver getDriver() {
        return driver;
    }

    public ArrayList<ILap> getLaps() {
        return laps;
    }

    public float getTime() {
        return time;
    }

    public boolean hasCrashed() {
        return hasCrashed;
    }

    public int getPlacement() {
        return placement;
    }

    public int getPoints() {
        return points;
    }

    public boolean hasFastestLap() {
        return hasFastestLap;
    }
}