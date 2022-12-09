package main.race.circuit;

import main.enums.Direction;

public interface ICircuitComponent {

    Direction getFrom();

    Direction getTo();
}