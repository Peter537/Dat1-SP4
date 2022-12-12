package main.data.impl;

import main.data.IDriver;

public class DriverImpl implements IDriver {

    private final int id;
    private final String name;
    private final int teamID;
    private int points;

    private final int experience;
    private final int corner;
    private final int consistency;
    private final int acceleration;

    public DriverImpl(int id, String name, int teamID, int experience, int corner, int consistency, int acceleration) {
        this.id = id;
        this.name = name;
        this.teamID = teamID;
        this.experience = experience;
        this.corner = corner;
        this.consistency = consistency;
        this.acceleration = acceleration;
        this.points = 0;
    }

    @Override
    public void addPoints(int newPoints) {
        this.points += newPoints;
    }

    @Override
    public int getPoints() {
        return this.points;
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

    @Override
    public int getExperience() {
        return this.experience;
    }

    @Override
    public int getCorner() {
        return this.corner;
    }

    @Override
    public int getConsistency() {
        return this.consistency;
    }

    @Override
    public int getAcceleration() {
        return this.acceleration;
    }

    @Override
    public String toString() {
        return "DriverImpl{" +
                "id=" + getID() +
                ", name='" + getName() + '\'' +
                ", teamID=" + getTeamID() +
                ", points=" + getPoints() +
                ", experience=" + getExperience() +
                ", corner=" + getCorner() +
                ", consistency=" + getConsistency() +
                ", acceleration=" + getAcceleration() +
                '}';
    }
}