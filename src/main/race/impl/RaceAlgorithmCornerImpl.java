package main.race.impl;

import main.data.ICar;
import main.data.IDriver;
import main.race.IRace;
import main.race.IRaceAlgorithm;
import main.race.circuit.ICircuitComponent;

import static java.lang.Math.sqrt;

public class RaceAlgorithmCornerImpl implements IRaceAlgorithm {

	public RaceAlgorithmCornerImpl() { }

	@Override
	public double getTime(IRace race, IDriver driver, ICar car, ICircuitComponent circuitComponent, double currentSpeed) {
		int angle = circuitComponent.asCorner().getAngle(); // 90 degrees
		int radius = circuitComponent.asCorner().getRadius(); // 100 m radius

		return (angle / 360.0) * (2 * Math.PI * radius / getSpeed(car, circuitComponent)); // t = (a / 360) * (2 * pi * r / v)
	}

	private double getSpeed(ICar car, ICircuitComponent circuitComponent) {
		double mass = car.getWeight(); // 1000 kg
		double drag = car.getAerodynamics(); // 10% drag
		double rollResistance = car.getTraction(); // 10% roll resistance
		int radius = circuitComponent.asCorner().getRadius(); // 100 m radius

		return sqrt(rollResistance*10 * 10 * radius * ((mass+mass*drag)/(mass)));  // v = sqrt(mu*g*r * ((m+m*drag)/(m)))
	}
}