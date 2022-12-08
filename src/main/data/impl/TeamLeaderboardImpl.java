package main.data.impl;

import main.data.ITeam;
import main.data.ITeamLeaderboard;

import java.util.ArrayList;

public class TeamLeaderboardImpl implements ITeamLeaderboard {

    private final ArrayList<ITeam> leaderboard;

    public TeamLeaderboardImpl(ArrayList<ITeam> teams) {
        this.leaderboard = teams;
        update();
    }

    @Override
    public void update() {
        getLeaderboard().sort((d1, d2) -> Integer.compare(d2.getPoints(), d1.getPoints()));
    }

    @Override
    public int getPlacement(ITeam team) {
        return getLeaderboard().indexOf(team) + 1;
    }

    @Override
    public ITeam getByPlacement(int placement) {
        return getLeaderboard().get(placement - 1);
    }

    @Override
    public ArrayList<ITeam> getLeaderboard() {
        return this.leaderboard;
    }
}