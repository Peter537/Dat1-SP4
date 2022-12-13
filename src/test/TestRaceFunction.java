package test;

import main.data.ICar;
import main.data.IDriver;
import main.data.ITeam;
import main.data.impl.CarImpl;
import main.data.impl.DriverImpl;
import main.data.impl.TeamImpl;
import main.database.DataBaseIO;
import main.race.ICircuit;
import main.race.IRace;
import main.race.impl.CircuitImpl;
import main.race.impl.RaceImpl;

import java.util.ArrayList;

public class TestRaceFunction {

    public static void main(String[] args) {
        ArrayList<ITeam> teams = getSomeDefaultData();

        ICircuit circuit1 = new CircuitImpl(1, "Circuit1", "Country1", 58, null);

        IRace race1 = new RaceImpl(1, circuit1, teams);

        race1.nextAction();
        race1.nextAction();
    }

    public static ArrayList<ITeam> getSomeDefaultData() {
        ArrayList<ITeam> teams = new ArrayList<>();

        // create 10 teams in total
        for (int i = 1; i <= 10; i++) {
            ICar car = new CarImpl(i, "car" + i, 1, 1, 1, 1);
            IDriver driver1 = new DriverImpl(i * 2 - 1, "driver" + (i * 2 - 1), i, 1, 1, 1, 1);
            IDriver driver2 = new DriverImpl(i * 2, "driver" + (i * 2), i, 1, 1, 1, 1);
            teams.add(new TeamImpl(i, "team" + i, car, driver1, driver2));
        }

        return teams;
    }
}