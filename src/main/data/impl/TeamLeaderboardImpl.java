package main.data.impl;

import main.data.ITeam;

import java.util.ArrayList;

public class TeamLeaderboardImpl {

    private final ArrayList<ITeam> leaderboard;

    public TeamLeaderboardImpl(ArrayList<ITeam> teams) {
        this.leaderboard = teams;
        update();
    }

    public void update() {
        leaderboard.sort((o1, o2) -> Integer.compare(o2.getPoints(), o1.getPoints()));
    }

    public int getPlacement(ITeam team) {
        return leaderboard.indexOf(team) + 1;
    }

    public ITeam getByPlacement(int placement) {
        return leaderboard.get(placement - 1);
    }

    public ArrayList<ITeam> getLeaderboard() {
        return leaderboard;
    }
}