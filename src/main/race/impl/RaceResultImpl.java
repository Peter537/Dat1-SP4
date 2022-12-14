package main.race.impl;

import main.data.IDriver;
import main.race.*;

import java.util.ArrayList;
import java.util.Comparator;

public class RaceResultImpl implements IRaceResult {

    private final ArrayList<IDriverResult> sortedResults;
    private final ILap fastestLap;

    public RaceResultImpl(ArrayList<IDriverResult> driverResults, ILap fastestLap) {
        this.sortedResults = driverResults;
        this.fastestLap = fastestLap;
        this.sortedResults.sort(Comparator.comparingInt(IDriverResult::getPlacement));
    }

    @Override
    public boolean isRace() {
        return true;
    }

    @Override
    public boolean isQualifier() {
        return false;
    }

    @Override
    public IRaceResult asRaceResult() {
        return this;
    }

    @Override
    public IQualifierResult asQualifierResult() {
        throw new UnsupportedOperationException("This is a race result");
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

    @Override
    public ILap getFastestLap() {
        return this.fastestLap;
    }
}