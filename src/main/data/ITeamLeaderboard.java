package main.data;

import java.util.ArrayList;

public interface ITeamLeaderboard {

    void update();

    int getPlacement(ITeam team);

    ITeam getByPlacement(int placement);

    ArrayList<ITeam> getLeaderboard();
}