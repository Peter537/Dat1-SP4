package main.race.circuit;

import main.enums.Direction;

public class CircuitComponentCornerImpl implements ICircuitComponentCorner {

    private final int radius;
    private final int angle;
    private final Direction from;
    private final Direction to;

    public CircuitComponentCornerImpl(int radius, int angle, Direction from, Direction to) {
        this.radius = radius;
        this.angle = angle;
        this.from = from;
        this.to = to;
    }

    @Override
    public int getRadius() {
        return this.radius;
    }

    @Override
    public int getAngle() {
        return this.angle;
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
        return true;
    }

    @Override
    public boolean isStraight() {
        return false;
    }

    @Override
    public ICircuitComponentCorner asCorner() {
        return this;
    }

    @Override
    public ICircuitComponentStraight asStraight() {
        throw new UnsupportedOperationException("This is a corner, not a straight");
    }
}