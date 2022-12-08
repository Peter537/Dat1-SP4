package main.race.impl;

import main.data.IDriver;
import main.race.IDriverResult;
import main.race.IQualifierResult;
import main.race.IRaceResult;

import java.util.ArrayList;

public class QualifierResultImpl implements IQualifierResult {

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

    @Override
    public IRaceResult asRaceResult() {
        throw new UnsupportedOperationException("This is a qualifier result");
    }

    @Override
    public IQualifierResult asQualifierResult() {
        return this;
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
    public ArrayList<IDriverResult> getSortedResults() {
        return sortedResults;
    }
}