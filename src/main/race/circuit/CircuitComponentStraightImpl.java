package main.race.circuit;

import main.enums.Direction;

public class CircuitComponentStraightImpl implements ICircuitComponent {

    private final int length;
    private final Direction from;
    private final Direction to;

    public CircuitComponentStraightImpl(int length, Direction from, Direction to) {
        this.length = length;
        this.from = from;
        this.to = to;
    }

    public int getLength() {
        return this.length;
    }

    public Direction getFrom() {
        return this.from;
    }

    public Direction getTo() {
        return this.to;
    }
}