package main.data.impl;

import main.data.ICar;

public class CarImpl implements ICar {

    private final int id;
    private final String name;

    private int horsePower;

    private int weight;

    private int aerodynamics;

    private int traction;

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
}