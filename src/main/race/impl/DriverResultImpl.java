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

    @Override
    public IDriver getDriver() {
        return driver;
    }

    @Override
    public ArrayList<ILap> getLaps() {
        return laps;
    }

    @Override
    public float getTime() {
        return time;
    }

    @Override
    public boolean hasCrashed() {
        return hasCrashed;
    }

    @Override
    public int getPlacement() {
        return placement;
    }

    @Override
    public int getPoints() {
        return points;
    }

    @Override
    public boolean hasFastestLap() {
        return hasFastestLap;
    }
}