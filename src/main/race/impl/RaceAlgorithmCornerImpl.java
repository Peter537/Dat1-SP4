package main.race.impl;

import main.data.ICar;
import main.race.IRaceAlgorithm;
import main.race.circuit.CircuitComponentCornerImpl;

import static java.lang.Math.sqrt;

public class RaceAlgorithmCornerImpl implements IRaceAlgorithm {

	public RaceAlgorithmCornerImpl() { }

	private double getSpeed(ICar car, CircuitComponentCornerImpl circuitComponentCorner) {
		double mass = car.getWeight(); // 1000 kg
		double drag = car.getAerodynamics(); // 10% drag
		double rollresistance = car.getTraction(); // 10% roll resistance

		int radius = circuitComponentCorner.getRadius(); // 100 m radius

		double speed = sqrt(radius * rollresistance * (1 + drag) * (mass * 10)); // v = sqrt(r * R * (1+D) * (m*10))
		return speed;
	}

	private double getTime(ICar car, CircuitComponentCornerImpl circuitComponentCorner) {
		int angle = circuitComponentCorner.getAngle(); // 90 degrees
		int radius = circuitComponentCorner.getRadius(); // 100 m radius

		double time = (angle / 360) * (2 * Math.PI * radius / getSpeed(car, circuitComponentCorner)); // t = (a / 360) * (2 * pi * r / v)
		return time;
	}
}