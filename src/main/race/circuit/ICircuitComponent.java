package main.race.circuit;

public interface ICircuitComponent {

    boolean isCorner();

    boolean isStraight();

    ICircuitComponentCorner asCorner();

    ICircuitComponentStraight asStraight();
}