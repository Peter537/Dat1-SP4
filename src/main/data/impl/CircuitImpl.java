package main.data.impl;

import main.data.ICircuit;

public class CircuitImpl implements ICircuit {

    private final int id;
    private final String name;
    private final String country;
    private final int laps;
    private final int lapLength;

    public CircuitImpl(int id, String name, String country, int laps, int lapLength) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.laps = laps;
        this.lapLength = lapLength;
    }

    @Override
    public ICircuit getCircuit() {
        return null;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getLaps() {
        return laps;
    }

    public int getLapLength() {
        return lapLength;
    }
}