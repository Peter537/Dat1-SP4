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

    @Override
    public Direction getFrom() {
        return this.from;
    }

    @Override
    public Direction getTo() {
        return this.to;
    }

    @Override
    public boolean isCorner() {
        return false;
    }

    @Override
    public boolean isStraight() {
        return true;
    }

    @Override
    public CircuitComponentCornerImpl asCorner() {
        throw new UnsupportedOperationException("This is a straight, not a corner");
    }

    @Override
    public CircuitComponentStraightImpl asStraight() {
        return this;
    }
}