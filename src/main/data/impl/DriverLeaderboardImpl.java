package main.data.impl;

import main.data.IDriver;

import java.util.ArrayList;

public class DriverLeaderboardImpl {

    private final ArrayList<IDriver> leaderboard;

    public DriverLeaderboardImpl(ArrayList<IDriver> drivers) {
        this.leaderboard = drivers;
        update();
    }

    public void update() {
        leaderboard.sort((o1, o2) -> Integer.compare(o2.getPoints(), o1.getPoints()));
    }

    public int getPlacement(IDriver driver) {
        return leaderboard.indexOf(driver) + 1;
    }

    public IDriver getByPlacement(int placement) {
        return leaderboard.get(placement - 1);
    }

    public ArrayList<IDriver> getLeaderboard() {
        return leaderboard;
    }
}