package main.race.impl;

import main.data.IDriver;
import main.race.IDriverResult;
import main.race.IRaceResult;

import java.util.ArrayList;

public class QualifierResult implements IRaceResult {

    private final ArrayList<IDriverResult> driverResults;

    public QualifierResult(ArrayList<IDriverResult> driverResults) {
        this.driverResults = driverResults;
    }

    public int getDriverPlacement(IDriver driver) {
        return driverResults.indexOf(driver);
    }

    public IDriverResult getDriverResult(IDriver driver) {
        return driverResults.get(driverResults.indexOf(driver));
    }

    @Override
    public IRaceResult getRaceResult() {
        return QualifierResult.this;
    }
}