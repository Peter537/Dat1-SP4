package main.race;

import main.race.circuit.ICircuitComponent;

import java.util.ArrayList;

public interface ICircuit {

    int getID();

    String getName();

    String getCountry();

    int getLaps();

    ArrayList<ICircuitComponent> getComponents();
}