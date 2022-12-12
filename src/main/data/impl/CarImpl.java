package main.data.impl;

import main.data.ICar;

public class CarImpl implements ICar {

    private final int id;
    private final String name;

    private final int horsePower;
    private final int weight;
    private final double aerodynamics;
    private final double traction;

    public CarImpl(int id, String name, int horsePower, int weight, double aerodynamics, double traction) {
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

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }

    @Override
    public int getWeight() {
        return this.weight;
    }

    @Override
    public double getAerodynamics() {
        return this.aerodynamics;
    }

    @Override
    public double getTraction() {
        return this.traction;
    }

    @Override
    public String toString() {
        return "CarImpl{" +
                "id=" + getID() +
                ", name='" + getName() + '\'' +
                ", horsePower=" + getHorsePower() +
                ", weight=" + getWeight() +
                ", aerodynamics=" + getAerodynamics() +
                ", traction=" + getTraction() +
                '}';
    }
}