package main.race.algorithm;

import main.data.ICar;
import main.data.IDriver;
import main.data.impl.DriverImpl;
import main.enums.WeatherCondition;
import main.race.ICircuit;
import main.race.IRace;
import main.race.circuit.ICircuitComponent;

import java.util.Random;

public class RaceAlgorithmCornerImpl implements IRaceAlgorithmCorner {

	public RaceAlgorithmCornerImpl() { }

	@Override
	public double getTime(IRace race, IDriver driver, ICar car, ICircuitComponent circuitComponent, double currentSpeed) {
		int angle = circuitComponent.asCorner().getAngle(); // 90 degrees
		int radius = circuitComponent.asCorner().getRadius(); // 100 m radius
		double speed = getSpeed(car, circuitComponent) * getSpeedProcent(driver, race.getWeatherCondition());

		Random r = new Random();
		return (angle / 360.0) * (2 * Math.PI * radius / speed) * r.nextGaussian(1.1, 0.01); // t = (a / 360) * (2 * pi * r / v)
	}

	private double getSpeed(ICar car, ICircuitComponent circuitComponent) {
		double drag = car.getAerodynamics(); // 10% drag
		double rollResistance = car.getTraction(); // 10% roll resistance
		int radius = circuitComponent.asCorner().getRadius(); // 100 m radius

		return Math.sqrt(rollResistance*10 * 10 * radius * (1+drag));  // v = sqrt(mu*g*r * (1+D))
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

		double speedProcent = 0.85;
		speedProcent += (experience - 45) * 0.0007;
		speedProcent += (corner - 40) * 0.0009;
		speedProcent += (consistency - 45) * 0.0006;
		speedProcent += (acceleration - 55) * 0.0002;

		if (weather == WeatherCondition.RAINY) {
			speedProcent *= 0.925;
		}

		return speedProcent;
	}
}