package main.data;

import java.util.ArrayList;

public interface ITeamLeaderboard {

    int getIndex(ITeam team);

    ITeam getByIndex(int index);

    ArrayList<ITeam> getLeaderboard();
}