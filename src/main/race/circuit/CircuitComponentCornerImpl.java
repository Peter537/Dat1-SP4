package main.race.circuit;

public class CircuitComponentCornerImpl implements ICircuitComponent {

    private final int radius;
    private final int angle;

    public CircuitComponentCornerImpl(int radius, int angle) {
        this.radius = radius;
        this.angle = angle;
    }

    public int getRadius() {
        return this.radius;
    }

    public int getAngle() {
        return this.angle;
    }
}