package main.race.impl;

import main.data.IDriver;
import main.race.ILap;
import main.race.IRace;

public class LapImpl implements ILap {

    private final IRace race;
    private final IDriver driver;
    final float time;

    public LapImpl(IRace race, IDriver driver, float time) {
        this.race = race;
        this.driver = driver;
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
    public float getTime() {
        return this.time;
    }
}