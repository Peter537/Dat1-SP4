package main.data.impl;

import main.data.ITeam;
import main.data.IUser;

public class UserImpl implements IUser {

    private ITeam team;

    public UserImpl(ITeam team) {
        this.team = team;
    }

    public ITeam getTeam() {
        return team;
    }

    public void setTeam(ITeam team) {
        this.team = team;
    }
}