package main.data;

import java.util.ArrayList;

public interface ITeam {

    int getPoints();

    int getID();

    String getName();

    ICar getCar();

    IDriver getDriver1();

    IDriver getDriver2();
}