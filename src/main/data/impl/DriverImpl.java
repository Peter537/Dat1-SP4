package main.data.impl;

import main.data.IDriver;

public class DriverImpl implements IDriver {

    private final int id;
    private final String name;
    private final int teamID;
    private int point;

    private int experience;

    private int corner;

    private int consistency;

    private int acceleration;

    public DriverImpl(int id, String name, int teamID, int experience, int corner, int consistency, int acceleration) {
        this.id = id;
        this.name = name;
        this.teamID = teamID;
        this.experience = experience;
        this.corner = corner;
        this.consistency = consistency;
        this.acceleration = acceleration;
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