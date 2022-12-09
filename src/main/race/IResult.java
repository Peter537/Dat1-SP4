package main.race;

import main.data.IDriver;

import java.util.ArrayList;

public interface IResult {

    boolean isRace();

    boolean isQualifier();

    IRaceResult asRaceResult();

    IQualifierResult asQualifierResult();

    int getDriverPlacement(IDriver driver);

    IDriverResult getDriverResult(IDriver driver);

    ArrayList<IDriverResult> getSortedResults();
}