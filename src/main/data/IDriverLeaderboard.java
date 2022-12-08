package main.data;

import java.util.ArrayList;

public interface IDriverLeaderboard {

    int getIndex(IDriver driver);

    IDriver getByIndex(int index);

    ArrayList<IDriver> getLeaderboard();
}