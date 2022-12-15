package main.race.circuit;

public class CircuitComponentStraightImpl implements ICircuitComponentStraight {

    private final int length;

    public CircuitComponentStraightImpl(int length) {
        this.length = length;
    }

    @Override
    public int getLength() {
        return this.length;
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