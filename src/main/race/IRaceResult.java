package main.race;

import main.data.IDriver;
import main.race.impl.DriverResultImpl;

public interface IRaceResult {

    int getDriverPlacement(IDriver driver);

    IDriverResult getDriverResult(IDriver driver);

    IRaceResult getRaceResult();
}