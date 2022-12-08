package main.race.impl;

import main.data.IDriver;
import main.race.IDriverResult;
import main.race.IResult;

import java.util.ArrayList;

public class QualifierResultImpl implements IResult {


    private final ArrayList<IDriverResult> sortedResults;

    public QualifierResultImpl(ArrayList<IDriverResult> driverResults) {
        // TODO: sort the driverResults by placement
        this.sortedResults = driverResults;
    }

    @Override
    public boolean isQualifier() {
        return true;
    }

    @Override
    public boolean isRace() {
        return false;
    }

    public int getDriverPlacement(IDriver driver) {
        return sortedResults.indexOf(driver);
    }

    public IDriverResult getDriverResult(IDriver driver) {
        return sortedResults.get(sortedResults.indexOf(driver));
    }

    @Override
    public ArrayList<IDriverResult> getSortedResult() {
        return sortedResults;
    }
}