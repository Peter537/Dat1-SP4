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
    private int point;

    public TeamImpl(int id, String name, ICar car, IDriver driver1, IDriver driver2) {
        this.id = id;
        this.name = name;
        this.car = car;
        this.driver1 = driver1;
        this.driver2 = driver2;
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

    public ICar getCar() {
        return car;
    }

    public IDriver getDriver1() {
        return driver1;
    }

    public IDriver getDriver2() {
        return driver2;
    }
}