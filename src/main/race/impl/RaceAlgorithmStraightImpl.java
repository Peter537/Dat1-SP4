package main.race.impl;

import main.data.ICar;
import main.race.IRaceAlgorithm;
import main.race.circuit.CircuitComponentStraightImpl;

public class RaceAlgorithmStraightImpl implements IRaceAlgorithm {

	double currentSpeed = 0; // current speed of the car measured in m/s
	// TODO: get current speed of car from a hashmap in race
	double currentAcceleration; // current acceleration of the car measured in m/s^2
	double distance = 0; // distance traveled by the car measured in m
	double time = 0; //current time in this circuit measured in s
	double dtime = 0.1; //time step measured in s

	public RaceAlgorithmStraightImpl() { }

	private double getTime(ICar car, CircuitComponentStraightImpl circuit) {
		double maxdistance = circuit.getLength(); //get length of circuit
		double time = 0;

		while (distance <= maxdistance) {
			currentAcceleration = getAcceleration(car, currentSpeed); //get acceleration from the car
			currentSpeed = getSpeed(currentSpeed, currentAcceleration); //	get speed from the car
			distance = distance + currentSpeed * dtime; //calculate distance traveled
			time = time + dtime; //calculate time
		}
		return time;
	}

	private double getAcceleration(ICar car, double currentSpeed) {
		int power = car.getHorsePower(); // 1000 hp
		double mass = car.getWeight(); // 1000 kg
		double drag = car.getAerodynamics(); // 10% drag
		double rollresistance = car.getTraction(); // 10% roll resistance
		double acceleration = (power - drag * currentSpeed * currentSpeed - rollresistance * currentSpeed) / mass; // F = ma -> a = F/m -> a = (P - Dv^2 - Rv) / m
		return acceleration;
	}

	private double getSpeed(double currentSpeed, double currentAcceleration) {
		currentSpeed = currentSpeed + currentAcceleration * dtime;
		return currentSpeed;
	}
}