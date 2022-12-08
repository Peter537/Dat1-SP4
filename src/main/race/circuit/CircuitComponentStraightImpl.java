package main.race.circuit;

public class CircuitComponentStraightImpl implements ICircuitComponent {

    private final int length;

    public CircuitComponentStraightImpl(int length) {
        this.length = length;
    }

    public int getLength() {
        return this.length;
    }
}