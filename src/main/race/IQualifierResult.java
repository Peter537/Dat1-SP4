package main.race;

import main.data.IDriver;

public interface IQualifierResult extends IResult {

    int getDriverPlacement(IDriver driver);

    IDriverResult getDriverResult(IDriver driver);
}