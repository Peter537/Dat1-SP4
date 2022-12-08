package main.data;

import java.util.ArrayList;

public interface IDriverLeaderboard {

    void update();

    int getPlacement(IDriver driver);

    IDriver getByPlacement(int placement);

    ArrayList<IDriver> getLeaderboard();
}