package main.race.impl;

import main.data.IDriver;
import main.race.ILap;
import main.race.IRace;

public class LapImpl implements ILap {

    private final IRace race;
    private final IDriver driver;
    private final int lapNumber;
    private final float time;

    public LapImpl(IRace race, IDriver driver, int lapNumber, float time) {
        this.race = race;
        this.driver = driver;
        this.lapNumber = lapNumber;
        this.time = time;
    }

    @Override
    public IRace getRace() {
        return this.race;
    }

    @Override
    public IDriver getDriver() {
        return this.driver;
    }

    @Override
    public int getLapNumber() {
        return this.lapNumber;
    }

    @Override
    public float getTime() {
        return this.time;
    }
}