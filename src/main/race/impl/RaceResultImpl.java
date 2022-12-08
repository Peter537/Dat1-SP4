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
        sortedResults.sort(Comparator.comparingInt(IDriverResult::getPlacement));
        this.fastestLap = fastestLap;
    }

    @Override
    public int getDriverPlacement(IDriver driver) {
        for (IDriverResult driverResult : sortedResults) {
            if (driverResult.getDriver().equals(driver)) {
                return driverResult.getPlacement();
            }
        }
        return 0;
    }

    @Override
    public IDriverResult getDriverResult(IDriver driver) {
        for (IDriverResult driverResult : sortedResults) {
            if (driverResult.getDriver().equals(driver)) {
                return driverResult;
            }
        }
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