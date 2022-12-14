package main.race.impl;

import main.data.IDriver;
import main.race.IDriverResult;
import main.race.ILap;
import main.race.IRace;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DriverResultImpl implements IDriverResult {

    private final IRace race;
    private final IDriver driver;
    private final ArrayList<ILap> laps;
    private final boolean isRace;

    private float time;
    private boolean hasCrashed;

    private int placement;
    private int points;
    private boolean hasFastestLap;

    public DriverResultImpl(IRace race, IDriver driver, ArrayList<ILap> laps, boolean isRace) {
        this.race = race;
        this.driver = driver;
        this.isRace = isRace;
        this.time = 0;
        if (laps.size() == 0) {
            this.laps = new ArrayList<>();
        } else {
            this.laps = laps;
            for (ILap lap : laps) {
                this.time += lap.getTime();
            }
        }
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
        if (isRace()) {
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
    }

    @Override
    public void setFastestLapStatus(boolean fastestLapStatus) {
        this.hasFastestLap = fastestLapStatus;
        if (fastestLapStatus && isRace()) {
            this.points += 1;
        }
    }

    @Override
    public void setCrashStatus(boolean crashStatus) {
        this.hasCrashed = crashStatus;
    }

    @Override
    public void addLap(ILap lap) {
        getLaps().add(lap);
        this.time += lap.getTime();
    }

    @Override
    public boolean isRace() {
        return this.isRace;
    }

    @Override
    public boolean isQualifier() {
        return !this.isRace;
    }

    @Override
    public void addPointsToDriver() {
        if (isRace()) {
            getDriver().addPoints(getPoints());
        }
    }

    @Override
    public String toString() {
        //Make time return a string in the format of mm:ss:ms
        int minutes = (int) (getTime() / 60);
        int seconds = (int) (getTime() % 60);
        int milliseconds = (int) ((getTime() * 1000) % 1000);
        String timeString = String.format("%02d:%02d.%03d", minutes, seconds, milliseconds);
        String placementString = String.format("%02d", getPlacement());
        if (placement == 21)
            placementString = "DNF";
        return placementString + ". " + driver.getName() + " (" + driver.getTeam().getName() + ") - " + timeString; //time as min;
    }
}