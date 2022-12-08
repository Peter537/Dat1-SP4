package main.race;

import main.data.IDriver;

import java.util.ArrayList;

public interface IResult {


    boolean isQualifier();

    boolean isRace();

    int getDriverPlacement(IDriver driver);
    IDriverResult getDriverResult(IDriver driver);

    ArrayList<IDriverResult> getSortedResult();


}