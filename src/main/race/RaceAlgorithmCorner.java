package main.race;

import static java.lang.Math.sqrt;

public class RaceAlgorithmCorner
	implements IRaceAlgorithm
{
//TODO: Get stats from Car
int power = 1000; // 1000 hp
double mass = 1000; // 1000 kg
double drag = 0.1; // 10% drag
double rollresistance = 0.1; // 10% roll resistance
// TODO: Get stats from Circuit
int radius = 100; // 100 m radius
int angle = 90; // 90 degrees


double speed = sqrt(radius * rollresistance * (1+drag) * (mass*10)); // v = sqrt(r * R * (1+D) * (m*10))

private double getTime()
{
	double time = (angle / 360) * (2 * Math.PI * radius / speed); // t = (a / 360) * (2 * pi * r / v)
	return time;
}

}

