package main.race.algorithm;

import main.data.ICar;
import main.data.IDriver;
import main.data.impl.DriverImpl;
import main.enums.WeatherCondition;
import main.race.ICircuit;
import main.race.IRace;
import main.race.circuit.ICircuitComponent;

public class RaceAlgorithmStraightImpl implements IRaceAlgorithmStraight {

	private final double dTime = 0.1; //time step measured in s

	public RaceAlgorithmStraightImpl() { }

	@Override
	public double getTime(IRace race, IDriver driver, ICar car, ICircuitComponent circuit, double currentSpeed) {
		double maxDistance = circuit.asStraight().getLength(); //get length of circuit
		double time = 0;
		double distance = 0; // distance traveled by the car measured in m

		double sProcent = getSpeedProcent(driver, race.getWeatherCondition()); //getSpeedProcent(driver, race.getWeatherCondition());
		while (distance <= maxDistance) {
			// current acceleration of the car measured in m/s^2
			double currentAcceleration = getAcceleration(car, currentSpeed); //get acceleration from the car
			double s = getSpeed(currentSpeed, currentAcceleration); //get speed from the acceleration
			currentSpeed = s * sProcent; //get speed from the driver
			//currentSpeed = getSpeed(currentSpeed, currentAcceleration) * getSpeedProcent(driver, race.getWeatherCondition()); //	get speed from the car
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

	public static void main(String[] args) {
		IDriver lowDataDriver = new DriverImpl(1, "test1", 60, 60, 60, 60);
		IDriver midDataDriver = new DriverImpl(2, "test2", 70, 70, 70, 70);
		IDriver highDataDriver = new DriverImpl(3, "test3", 80, 80, 80, 80);

		System.out.println("Sunny:");
		System.out.println("Low Data Driver: " + getSpeedProcent(lowDataDriver, WeatherCondition.SUNNY));
		System.out.println("Mid Data Driver: " + getSpeedProcent(midDataDriver, WeatherCondition.SUNNY));
		System.out.println("High Data Driver: " + getSpeedProcent(highDataDriver, WeatherCondition.SUNNY));

		System.out.println();
		System.out.println("Rainy:");
		System.out.println("Low Data Driver: " + getSpeedProcent(lowDataDriver, WeatherCondition.RAINY));
		System.out.println("Mid Data Driver: " + getSpeedProcent(midDataDriver, WeatherCondition.RAINY));
		System.out.println("High Data Driver: " + getSpeedProcent(highDataDriver, WeatherCondition.RAINY));
	}

	private static double getSpeedProcent(IDriver driver, WeatherCondition weather) {
		int experience = driver.getExperience();
		int corner = driver.getCorner();
		int consistency = driver.getConsistency();
		int acceleration = driver.getAcceleration();

		double speedProcent = 0.8;
		speedProcent += (experience) * 0.0007; // 0.0 -> 0.0003
		speedProcent += (corner) * 0.0002; // 0.0 -> 0.0001
		speedProcent += (consistency) * 0.0008; // 0.0 -> 0.0004
		speedProcent += (acceleration) * 0.0009; // 0.0 -> 0.0005

		if (weather == WeatherCondition.RAINY) {
			speedProcent *= 0.98;
		}

		return speedProcent;
	}
}