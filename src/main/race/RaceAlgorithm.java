package main.race;

public class RaceAlgorithm
{
double currentSpeed = 0;
double currentAcceleration = 0;
double distance = 0;
double time = 0;
double dtime = 0.1;
double maxdistance = 1000;


while (distance < maxdistance)
{
currentAcceleration = getAcceleration(currentSpeed);
currentSpeed = getSpeed(currentSpeed, currentAcceleration);
distance = getDistance(distance, currentSpeed);
time = getTime(time, dtime);
}

private double getTime(double time, double dtime)
{
return time + dtime;
}

private double getDistance(double distance, double currentSpeed)
{
return distance + currentSpeed * dtime;
}

private double getSpeed(double currentSpeed, double currentAcceleration)
{
return currentSpeed + currentAcceleration * dtime;
}

private double getAcceleration(double currentSpeed)
{

}


}
