package main.race;

public class RaceAlgorithmStraight implements IRaceAlgorithm
{


double currentSpeed = 0; // current speed of the car measured in m/s
double currentAcceleration = 0; // current acceleration of the car measured in m/s^2
double distance = 0; // distance traveled by the car measured in m
double time = 0; //current time os race measured in s
double dtime = 0.1; //time step measured in s
//TODO: get maxdistance from circuit
int maxdistance = 1000; //max length of race measured in m


private double getTime()
{
	while (distance <= maxdistance)
	{
		currentAcceleration = getAcceleration(currentSpeed); //get acceleration from the car
		currentSpeed = getSpeed(currentSpeed, currentAcceleration);; //	get speed from the car
		distance = distance + currentSpeed * dtime; //calculate distance traveled
		time = time + dtime; //calculate time
	}
	return time;
}

private double getAcceleration(double currentSpeed)
{
	//TODO: get stats from car
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
