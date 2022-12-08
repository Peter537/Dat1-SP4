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
        this.time = 0;
        this.hasCrashed = false;
        this.placement = 0;
        this.points = 0;
        this.hasFastestLap = false;
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

    @Override
    public void setPlacement(int placement) {
        this.placement = placement;
        switch (placement) {
            case 1 -> this.points = 25;
            case 2 -> this.points = 18;
            case 3 -> this.points = 15;
            case 4 -> this.points = 12;
            case 5 -> this.points = 10;
            case 6 -> this.points = 8;
            case 7 -> this.points = 6;
            case 8 -> this.points = 4;
            case 9 -> this.points = 2;
            case 10 -> this.points = 1;
            default -> this.points = 0;
        }
    }

    @Override
    public void setHasFastestLap(boolean hasFastestLap) {
        this.hasFastestLap = hasFastestLap;
    }

    @Override
    public void setHasCrashed(boolean hasCrashed) {
        this.hasCrashed = hasCrashed;
    }

    @Override
    public void addLap(ILap lap) {
        laps.add(lap);
        time += lap.getTime();
    }
}