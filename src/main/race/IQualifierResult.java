package main.race;

import main.data.IDriver;

import java.util.ArrayList;

public interface IQualifierResult extends IResult {

    int getDriverPlacement(IDriver driver);

    IDriverResult getDriverResult(IDriver driver);

    ArrayList<IDriverResult> getSortedResult();
}
