package main.race;

import main.data.IDriver;

public interface ILap {

IRace getRace();

IDriver getDriver();

float getTime();
}