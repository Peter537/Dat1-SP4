package main.race;

import java.util.ArrayList;

public interface IRaceResult extends IResult {

    int getDriverPlacement(IDriverResult driver);

    IDriverResult getDriverResult(IDriverResult driver);

    ILap getFastestLap();

    ArrayList<IDriverResult> getSortedResult();
}