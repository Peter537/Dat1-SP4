package main.race.circuit;

import main.enums.Direction;

public class CircuitComponentStraightImpl implements ICircuitComponentStraight {

    private final int length;
    private final Direction from;
    private final Direction to;

    public CircuitComponentStraightImpl(int length, Direction from, Direction to) {
        this.length = length;
        this.from = from;
        this.to = to;
    }

    @Override
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
    public ICircuitComponentCorner asCorner() {
        throw new UnsupportedOperationException("This is a straight, not a corner");
    }

    @Override
    public ICircuitComponentStraight asStraight() {
        return this;
    }
}