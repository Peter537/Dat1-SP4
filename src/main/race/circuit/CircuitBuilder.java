package main.race.circuit;

import main.race.ICircuit;
import main.race.impl.CircuitImpl;

import java.util.ArrayList;

public class CircuitBuilder {

    public CircuitBuilder() { }

    public ArrayList<ICircuit> createCircuits() {
        ArrayList<ICircuit> circuits = new ArrayList<>();

        // Create circuit 1
        ArrayList<ICircuitComponent> components1 = new ArrayList<>();

        ICircuit circuit1 = new CircuitImpl(1, "Copenhagen", "Denmark", 63, components1);
        circuits.add(circuit1);

        // Create circuit 2
        ArrayList<ICircuitComponent> components2 = new ArrayList<>();

        ICircuit circuit2 = new CircuitImpl(2, "Paris", "France", 67, components2);
        circuits.add(circuit2);

        // Create circuit 3
        ArrayList<ICircuitComponent> components3 = new ArrayList<>();

        ICircuit circuit3 = new CircuitImpl(3, "Munich", "Germany", 68, components3);
        circuits.add(circuit3);

        // Create circuit 4
        ArrayList<ICircuitComponent> components4 = new ArrayList<>();

        ICircuit circuit4 = new CircuitImpl(4, "Rome", "Italy", 69, components4);
        circuits.add(circuit4);

        // Create circuit 5
        ArrayList<ICircuitComponent> components5 = new ArrayList<>();

        ICircuit circuit5 = new CircuitImpl(5, "Madrid", "Spain", 59, components5);
        circuits.add(circuit5);

        return circuits;
    }
}