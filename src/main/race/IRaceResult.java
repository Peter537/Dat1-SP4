package main.race;

import main.data.IDriver;

import java.util.ArrayList;

public interface IRaceResult extends IResult {

    int getDriverPlacement(IDriver driver);

    IDriverResult getDriverResult(IDriver driver);

    ILap getFastestLap();

    ArrayList<IDriverResult> getSortedResult();
}