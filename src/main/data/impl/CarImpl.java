package main.data.impl;

import main.data.ICar;

public class CarImpl implements ICar {

    private final int id;
    private final String name;

    private final int horsePower;

    private final int weight;

    private final double aerodynamics;

    private final double traction;

    public CarImpl(int id, String name, int horsePower, int weight, int aerodynamics, int traction) {
        this.id = id;
        this.name = name;
        this.horsePower = horsePower;
        this.weight = weight;
        this.aerodynamics = aerodynamics;
        this.traction = traction;
    }

    @Override
    public int getID() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public int getWeight() {
        return weight;
    }

    public double getAerodynamics() {
        return aerodynamics;
    }

    public double getTraction() {
        return traction;
    }
}