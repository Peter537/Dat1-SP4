package main.data.impl;

import main.data.ICar;

public class CarImpl implements ICar {

private final int id;
private final String name;

    public CarImpl(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public ICar getCar() {
        return CarImpl.this;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}