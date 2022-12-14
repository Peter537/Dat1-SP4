package main.race;

import main.data.ICar;
import main.data.IDriver;
import main.race.circuit.ICircuitComponent;

public interface IRaceAlgorithm {

    double getTime(IRace race, IDriver driver, ICar car, ICircuitComponent circuitComponent, double currentSpeed);
}