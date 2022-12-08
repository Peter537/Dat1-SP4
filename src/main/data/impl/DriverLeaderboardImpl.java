package main.data.impl;

import main.data.IDriver;
import main.data.IDriverLeaderboard;

import java.util.ArrayList;

public class DriverLeaderboardImpl implements IDriverLeaderboard {

    private final ArrayList<IDriver> leaderboard;

    public DriverLeaderboardImpl(ArrayList<IDriver> drivers) {
        this.leaderboard = drivers;
        update();
    }

    @Override
    public void update() {
        leaderboard.sort((d1, d2) -> Integer.compare(d2.getPoints(), d1.getPoints()));
    }

    @Override
    public int getPlacement(IDriver driver) {
        return leaderboard.indexOf(driver) + 1;
    }

    @Override
    public IDriver getByPlacement(int placement) {
        return leaderboard.get(placement - 1);
    }

    @Override
    public ArrayList<IDriver> getLeaderboard() {
        return leaderboard;
    }
}