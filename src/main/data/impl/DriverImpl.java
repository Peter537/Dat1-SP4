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
        return point;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTeamID() {
        return teamID;
    }
}