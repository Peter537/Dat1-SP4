package main.race.impl;

import main.data.IDriver;
import main.race.IDriverResult;
import main.race.ILap;
import main.race.IRaceResult;

import java.util.ArrayList;

public class RaceResult implements IRaceResult {

    private final ArrayList<IDriverResult> sortedResults;
    private final ILap fastestLap;

    public RaceResult(ArrayList<IDriverResult> sortedResults, ILap fastestLap) {
        this.sortedResults = sortedResults;
        this.fastestLap = fastestLap;
    }
    public int getDriverPlacement(IDriverResult driver) {
        return sortedResults.indexOf(driver);
    }

    public IDriverResult getDriverResult(IDriverResult driver) {
        return sortedResults.get(sortedResults.indexOf(driver));
    }

    public ArrayList<IDriverResult> getSortedResults() {
        return sortedResults;
    }

    public ILap getFastestLap() {
        return fastestLap;
    }

    @Override
    public int getDriverPlacement(IDriver driver) {
        return sortedResults.indexOf(driver);
    }

    @Override
    public IDriverResult getDriverResult(IDriver driver) {
        return sortedResults.get(sortedResults.indexOf(driver));
    }

    @Override
    public IRaceResult getRaceResult() {
        return RaceResult.this;
    }
}