package main.race.algorithm;

import main.data.ICar;
import main.data.IDriver;
import main.race.IRace;
import main.race.circuit.ICircuitComponent;

public interface IRaceAlgorithm {

    double getTime(IRace race, IDriver driver, ICar car, ICircuitComponent circuitComponent, double currentSpeed);
}