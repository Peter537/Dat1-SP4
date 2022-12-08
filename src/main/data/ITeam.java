package main.data;

public interface ITeam {

    void addPoints(int points);

    int getPoints();

    int getID();

    String getName();

    ICar getCar();

    IDriver getDriver1();

    IDriver getDriver2();
}