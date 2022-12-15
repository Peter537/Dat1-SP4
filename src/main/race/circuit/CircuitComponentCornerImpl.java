package main.race.circuit;

public class CircuitComponentCornerImpl implements ICircuitComponentCorner {

    private final int radius;
    private final int angle;

    public CircuitComponentCornerImpl(int radius, int angle) {
        this.radius = radius;
        this.angle = angle;
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