package main.race.impl;

import main.data.IDriver;
import main.race.*;

import java.util.ArrayList;

public class RaceResultImpl implements IRaceResult {

    private final ArrayList<IDriverResult> sortedResults;
    private final ILap fastestLap;

    public RaceResultImpl(ArrayList<IDriverResult> driverResults, ILap fastestLap) {
        // TODO: sort the driverResults by placement
        this.sortedResults = driverResults;
        this.fastestLap = fastestLap;
    }

    @Override
    public int getDriverPlacement(IDriver driver) {
        // TODO: implement this
        return 0;
    }

    @Override
    public IDriverResult getDriverResult(IDriver driver) {
        // TODO: implement this
        return null;
    }

    @Override
    public ArrayList<IDriverResult> getSortedResults() {
        return sortedResults;
    }

    @Override
    public ILap getFastestLap() {
        return fastestLap;
    }

    @Override
    public boolean isQualifier() {
        return false;
    }

    @Override
    public boolean isRace() {
        return true;
    }

    @Override
    public IRaceResult asRaceResult() {
        return null;
    }

    @Override
    public IQualifierResult asQualifierResult() {
        return null;
    }
}