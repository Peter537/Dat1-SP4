package main.race.circuit;

import main.enums.Direction;

public interface ICircuitComponent {

    Direction getFrom();

    Direction getTo();

    boolean isCorner();

    boolean isStraight();

    CircuitComponentCornerImpl asCorner();

    CircuitComponentStraightImpl asStraight();
}