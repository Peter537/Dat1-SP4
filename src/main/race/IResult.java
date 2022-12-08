package main.race;

import main.data.IDriver;

import java.util.ArrayList;

public interface IResult {


    int getDriverPlacement(IDriver driver);
    IDriverResult getDriverResult(IDriver driver);

    boolean isQualifier();

    boolean isRace();

    IRaceResult asRaceResult();

    IQualifierResult asQualifierResult();
    ArrayList<IDriverResult> getSortedResult();


}