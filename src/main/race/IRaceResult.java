package main.race;

import main.data.IDriver;
import main.race.impl.DriverResultImpl;

public interface IRaceResult {

    public int getDriverPlacement(IDriver driver);
    public IDriverResult getDriverResult(IDriver driver);

    public IRaceResult getRaceResult();


}