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

        components1.add(new CircuitComponentStraightImpl(1000));
        components1.add(new CircuitComponentCornerImpl(100, 90));
        components1.add(new CircuitComponentStraightImpl(1000));
        components1.add(new CircuitComponentCornerImpl(100, 90));
        components1.add(new CircuitComponentStraightImpl(1500));
        components1.add(new CircuitComponentCornerImpl(50, 180));
        components1.add(new CircuitComponentStraightImpl(500));
        components1.add(new CircuitComponentCornerImpl(50, 90));
        components1.add(new CircuitComponentStraightImpl(1500));
        components1.add(new CircuitComponentCornerImpl(50, 90));
        components1.add(new CircuitComponentStraightImpl(500));
        components1.add(new CircuitComponentCornerImpl(50, 90));
        components1.add(new CircuitComponentStraightImpl(500));
        components1.add(new CircuitComponentCornerImpl(50, 90));
        components1.add(new CircuitComponentStraightImpl(500));




        ICircuit circuit1 = new CircuitImpl(1, "Copenhagen", "Denmark", 63, components1);
        circuits.add(circuit1);

        // Create circuit 2
        ArrayList<ICircuitComponent> components2 = new ArrayList<>();

        components2.add(new CircuitComponentStraightImpl(500));
        components2.add(new CircuitComponentCornerImpl(50, 180));
        components2.add(new CircuitComponentStraightImpl(200));
        components2.add(new CircuitComponentCornerImpl(80, 180));
        components2.add(new CircuitComponentStraightImpl(500));
        components2.add(new CircuitComponentCornerImpl(100, 45));
        components2.add(new CircuitComponentStraightImpl(200));
        components2.add(new CircuitComponentCornerImpl(200, 180));
        components2.add(new CircuitComponentStraightImpl(500));
        components2.add(new CircuitComponentCornerImpl(400, 90));
        components2.add(new CircuitComponentStraightImpl(2000));
        components2.add(new CircuitComponentCornerImpl(80, 135));
        components2.add(new CircuitComponentStraightImpl(500));


        ICircuit circuit2 = new CircuitImpl(2, "Paris", "France", 67, components2);
        circuits.add(circuit2);


        // Create circuit 3
        ArrayList<ICircuitComponent> components3 = new ArrayList<>();

        ICircuit circuit3 = new CircuitImpl(3, "Munich", "Germany", 68, components3);
        circuits.add(circuit3);

        // Create circuit 4
        ArrayList<ICircuitComponent> components4 = new ArrayList<>();

        // make a method that adds components to components4 with alternating straight and corner components in the following order: 1000, 180, 50, 180, 800, 85, 200, 120, 900, 100, 80, 110, 2000, 160, 300, 100, 200, 130, 80
            components4.add(new CircuitComponentStraightImpl(1000));
            components4.add(new CircuitComponentCornerImpl(50, 180));
            components4.add(new CircuitComponentStraightImpl(50));
            components4.add(new CircuitComponentCornerImpl(30, 180));
            components4.add(new CircuitComponentStraightImpl(800));
            components4.add(new CircuitComponentCornerImpl(40, 90));
            components4.add(new CircuitComponentStraightImpl(200));
            components4.add(new CircuitComponentCornerImpl(120, 230));
            components4.add(new CircuitComponentStraightImpl(900));
            components4.add(new CircuitComponentCornerImpl(50, 100));
            components4.add(new CircuitComponentStraightImpl(80));
            components4.add(new CircuitComponentCornerImpl(70, 110));
            components4.add(new CircuitComponentStraightImpl(2000));
            components4.add(new CircuitComponentCornerImpl(500, 200));
            components4.add(new CircuitComponentStraightImpl(300));
            components4.add(new CircuitComponentCornerImpl(80, 100));
            components4.add(new CircuitComponentStraightImpl(200));
            components4.add(new CircuitComponentCornerImpl(80, 120));
            components4.add(new CircuitComponentStraightImpl(80));


        ICircuit circuit4 = new CircuitImpl(4, "Rome", "Italy", 69, components4);
        circuits.add(circuit4);

        // Create circuit 5
        ArrayList<ICircuitComponent> components5 = new ArrayList<>();

        components5.add(new CircuitComponentStraightImpl(750));
        components5.add(new CircuitComponentCornerImpl(100, 90));
        components5.add(new CircuitComponentStraightImpl(300));
        components5.add(new CircuitComponentCornerImpl(40, 90));
        components5.add(new CircuitComponentStraightImpl(100));
        components5.add(new CircuitComponentCornerImpl(40, 90));
        components5.add(new CircuitComponentStraightImpl(120));
        components5.add(new CircuitComponentCornerImpl(70, 90));
        components5.add(new CircuitComponentStraightImpl(300));
        components5.add(new CircuitComponentCornerImpl(60, 180));
        components5.add(new CircuitComponentStraightImpl(250));
        components5.add(new CircuitComponentCornerImpl(60, 90));
        components5.add(new CircuitComponentStraightImpl(500));
        components5.add(new CircuitComponentCornerImpl(80, 75));
        components5.add(new CircuitComponentStraightImpl(1000));
        components5.add(new CircuitComponentCornerImpl(100, 100));
        components5.add(new CircuitComponentStraightImpl(400));
        components5.add(new CircuitComponentCornerImpl(100, 120));
        components5.add(new CircuitComponentStraightImpl(100));
        components5.add(new CircuitComponentCornerImpl(70, 180));
        components5.add(new CircuitComponentStraightImpl(100));
        components5.add(new CircuitComponentCornerImpl(110, 180));
        components5.add(new CircuitComponentStraightImpl(120));
        components5.add(new CircuitComponentCornerImpl(40, 25));
        components5.add(new CircuitComponentStraightImpl(100));
        components5.add(new CircuitComponentCornerImpl(40, 25));





        ICircuit circuit5 = new CircuitImpl(5, "Madrid", "Spain", 59, components5);
        circuits.add(circuit5);

        return circuits;
    }
}