package main.data.impl;

import main.data.IDriver;

public class DriverImpl implements IDriver {

    private final int id;
    private final String name;
    private final int teamID;
    private int point;

    public DriverImpl(int id, String name, int teamID) {
        this.id = id;
        this.name = name;
        this.teamID = teamID;
    }

    @Override
    public void addPoints(int points) {
        point += points;
    }

    @Override
    public int getPoints() {
        return this.point;
    }

    @Override
    public int getID() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getTeamID() {
        return this.teamID;
    }
}