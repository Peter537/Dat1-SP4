package main.race.impl;

import main.data.IDriver;
import main.race.ILap;
import main.race.IRace;

public class LapImpl {

    private final IRace race;
    private final IDriver driver;
    final float time;

    public LapImpl(IRace race, IDriver driver, float time) {
        this.race = race;
        this.driver = driver;
        this.time = time;
    }

    public IRace getRace() {
        return race;
    }

    public IDriver getDriver() {
        return driver;
    }

    public float getTime() {
        return time;
    }
}