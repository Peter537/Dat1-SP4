package main.data.impl;

import main.data.IDriver;
import main.data.ITeam;

public class DriverImpl implements IDriver {

    private final int id;
    private final String name;
    private ITeam team;
    private int points;

    private final int experience;
    private final int corner;
    private final int consistency;
    private final int acceleration;

    public DriverImpl(int id, String name, int experience, int corner, int consistency, int acceleration) {
        this.id = id;
        this.name = name;
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
    public void setTeam(ITeam team) {
        this.team = team;
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
    public ITeam getTeam() {
        return this.team;
    }

    @Override
    public String toString() {
        return "DriverImpl{" +
                "id=" + getID() +
                ", name='" + getName() + '\'' +
                ", teamID=" + this.getTeam().getID() +
                ", points=" + getPoints() +
                ", experience=" + getExperience() +
                ", corner=" + getCorner() +
                ", consistency=" + getConsistency() +
                ", acceleration=" + getAcceleration() +
                '}';
    }
}