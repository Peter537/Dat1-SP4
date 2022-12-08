package main.race;

public class RaceAlgorithm
{
double currentSpeed = 0; // current speed of the car measured in m/s
double currentAcceleration = 0; // current acceleration of the car measured in m/s^2
double distance = 0; // distance traveled by the car measured in m
double time = 0; //current time os race measured in s
double dtime = 0.1; //time step measured in s
double maxdistance = 1000; //max length of race measured in m


private void runrace()
{
	while (distance < maxdistance)
	{
		currentAcceleration = getAcceleration(currentSpeed);
		currentSpeed = getSpeed(currentSpeed, currentAcceleration);;
		distance = distance + currentSpeed * dtime;
		time = time + dtime;
	}
}

private double getAcceleration(double currentSpeed)
{
	int power = 1000; // 1000 hp
	double mass = 1000; // 1000 kg
	double drag = 0.1; // 10% drag
	double rollresistance = 0.1; // 10% roll resistance
	double acceleration = (power - drag * currentSpeed * currentSpeed - rollresistance * currentSpeed) / mass; // F = ma -> a = F/m -> a = (P - Dv^2 - Rv) / m
	return acceleration;

}
 private double getSpeed(double currentSpeed, double currentAcceleration)
 {
	 currentSpeed = currentSpeed + currentAcceleration * dtime;
 		 return currentSpeed;
 }

}
