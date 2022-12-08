package main.race.circuit;

import main.race.ICircuit;

import java.util.ArrayList;

public class CircuitImpl implements ICircuit {

    private final int id;
    private final String name;
    private final String country;
    private final int laps;
    private final ArrayList<ICircuitComponent> components;

    public CircuitImpl(int id, String name, String country, int laps, ArrayList<ICircuitComponent> components) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.laps = laps;
        this.components = components;
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
    public String getCountry() {
        return this.country;
    }

    @Override
    public int getLaps() {
        return this.laps;
    }

    @Override
    public ArrayList<ICircuitComponent> getComponents() {
        return this.components;
    }
}