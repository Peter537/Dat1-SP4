package main.race.impl;

import main.data.IDriver;
import main.race.IDriverResult;
import main.race.IQualifierResult;
import main.race.IRaceResult;

import java.util.ArrayList;
import java.util.Comparator;

public class QualifierResultImpl implements IQualifierResult {

    private final ArrayList<IDriverResult> sortedResults;

    public QualifierResultImpl(ArrayList<IDriverResult> driverResults) {
        // TODO: sort the driverResults by placement
        this.sortedResults = driverResults;
        this.sortedResults.sort(Comparator.comparingInt(IDriverResult::getPlacement));
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
        for (IDriverResult driverResult : getSortedResults()) {
            if (driverResult.getDriver().equals(driver)) {
                return driverResult.getPlacement();
            }
        }
        return 0;
    }

    @Override
    public IDriverResult getDriverResult(IDriver driver) {
        for (IDriverResult driverResult : getSortedResults()) {
            if (driverResult.getDriver().equals(driver)) {
                return driverResult;
            }
        }
        return null;
    }

    @Override
    public ArrayList<IDriverResult> getSortedResults() {
        return this.sortedResults;
    }
}