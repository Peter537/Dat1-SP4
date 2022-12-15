package main.data;

public interface IDriver {

    void addPoints(int points);

    int getPoints();

    int getID();

    String getName();

    int getExperience();

    int getCorner();

    int getConsistency();

    int getAcceleration();

    ITeam getTeam();

    void setTeam(ITeam team);
}