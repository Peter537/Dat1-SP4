package main.race;

import main.data.IDriver;

import java.util.ArrayList;

public interface IQualifierResult extends IResult {

    ArrayList<IDriver> getGridList();
}