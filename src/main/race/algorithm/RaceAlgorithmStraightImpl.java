package main.race.algorithm;

import main.data.ICar;
import main.data.IDriver;
import main.race.IRace;
import main.race.circuit.ICircuitComponent;

public class RaceAlgorithmStraightImpl implements IRaceAlgorithm {

	private final double dTime = 0.1; //time step measured in s

	public RaceAlgorithmStraightImpl() { }

	@Override
	public double getTime(IRace race, IDriver driver, ICar car, ICircuitComponent circuit, double currentSpeed) {
		double maxDistance = circuit.asStraight().getLength(); //get length of circuit
		double time = 0;
		double distance = 0; // distance traveled by the car measured in m

		while (distance <= maxDistance) {
			// current acceleration of the car measured in m/s^2
			double currentAcceleration = getAcceleration(car, currentSpeed); //get acceleration from the car
			currentSpeed = getSpeed(currentSpeed, currentAcceleration); //	get speed from the car
			distance = distance + currentSpeed * dTime; //calculate distance traveled
			time = time + dTime; //calculate time
		}
		race.setNewSpeed(driver, currentSpeed);
		return time;
	}

	private double getAcceleration(ICar car, double currentSpeed) {
		int power = car.getHorsePower(); // 1000 hp
		double mass = car.getWeight(); // 1000 kg
		double drag = car.getAerodynamics(); // 10% drag
		double rollResistance = car.getTraction(); // 10% roll resistance
		return (power - drag * currentSpeed * currentSpeed - rollResistance * currentSpeed) / mass; // F = ma -> a = F/m -> a = (P - Dv^2 - Rv) / m
	}

	private double getSpeed(double currentSpeed, double currentAcceleration) {
		currentSpeed = currentSpeed + currentAcceleration * dTime;
		return currentSpeed;
	}
}