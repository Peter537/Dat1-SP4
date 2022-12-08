package main.race;

public class RaceAlgorithm
{
double currentSpeed = 0;
double currentAcceleration = 0;
double distance = 0;
double time = 0;
double dtime = 0.1;
double maxdistance = 1000;


private void runrace()
{
	while (distance < maxdistance)
	{
		currentAcceleration = getAcceleration(currentSpeed);
		currentSpeed = currentSpeed + currentAcceleration * dtime;
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
	double acceleration = (power - drag * currentSpeed * currentSpeed - rollresistance * currentSpeed) / mass;
	return acceleration;

}

}
