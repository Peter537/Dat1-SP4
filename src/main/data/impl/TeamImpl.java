package main.data.impl;

import main.data.ICar;
import main.data.IDriver;
import main.data.ITeam;

public class TeamImpl implements ITeam {

    private final int id;
    private final String name;
    private final ICar car;
    private final IDriver driver1;
    private final IDriver driver2;
    private int points;

    public TeamImpl(int id, String name, ICar car, IDriver driver1, IDriver driver2) {
        this.id = id;
        this.name = name;
        this.car = car;
        this.driver1 = driver1;
        this.driver2 = driver2;
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
    public ICar getCar() {
        return this.car;
    }

    @Override
    public IDriver getDriver1() {
        return this.driver1;
    }

    @Override
    public IDriver getDriver2() {
        return this.driver2;
    }
}