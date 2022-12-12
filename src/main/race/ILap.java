package main.race;

import main.data.IDriver;

public interface ILap {

    IRace getRace();

    IDriver getDriver();

    int getLapNumber();

    float getTime();
}