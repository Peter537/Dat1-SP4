package main.race.impl;

import main.data.IDriver;
import main.race.IDriverResult;
import main.race.ILap;
import main.race.IResult;

import java.util.ArrayList;

public class ResultImpl implements IResult {

    private final ArrayList<IDriverResult> sortedResults;
    private final ILap fastestLap;

    public ResultImpl(ArrayList<IDriverResult> driverResults, ILap fastestLap) {
        // TODO: sort the driverResults by placement
        this.sortedResults = driverResults;
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
    public boolean isQualifier() {
        return false;
    }

    @Override
    public boolean isRace() {
        return true;
    }

    @Override
    public int getDriverPlacement(IDriver driver) {
        return getSortedResult().indexOf(driver) + 1;
    }

    @Override
    public IDriverResult getDriverResult(IDriver driver) {
        return getSortedResult().get(getDriverPlacement(driver) - 1);
    }

    @Override
    public ArrayList<IDriverResult> getSortedResult() {
        return this.sortedResults;
    }

}