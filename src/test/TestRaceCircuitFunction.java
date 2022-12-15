package test;

import main.data.ICar;
import main.data.IDriver;
import main.data.ITeam;
import main.data.impl.CarImpl;
import main.data.impl.DriverImpl;
import main.data.impl.TeamImpl;
import main.race.ICircuit;
import main.race.IRace;
import main.race.circuit.CircuitComponentCornerImpl;
import main.race.circuit.CircuitComponentStraightImpl;
import main.race.circuit.ICircuitComponent;
import main.race.impl.CircuitImpl;
import main.race.impl.RaceImpl;

import java.util.ArrayList;
import java.util.Random;

public class TestRaceCircuitFunction {

    public static void main(String[] args) {
        TestRaceCircuitFunction testRaceCircuitFunction = new TestRaceCircuitFunction();
        testRaceCircuitFunction.run();
    }

    public void run() {
        ArrayList<ITeam> teams = getSomeDefaultTeamData();

        ICircuit circuit1 = getCircuit();

        IRace race1 = new RaceImpl(2022, circuit1, teams);

        race1.nextAction();
        race1.nextAction();
    }

    public ArrayList<ITeam> getSomeDefaultTeamData() {
        ArrayList<ITeam> teams = new ArrayList<>();

        Random r = new Random();

        // create 10 teams in total
        for (int i = 1; i <= 10; i++) {
            ICar car = new CarImpl(i, "car" + i, r.nextInt(50) + 1000, r.nextInt(50) + 1000, r.nextDouble(0.5) + 0.5, r.nextDouble(0.5) + 0.5);
            //IDriver driver1 = new DriverImpl(i * 2 - 1, "driver" + (i * 2 - 1), r.nextInt(20) + 60, r.nextInt(20) + 60, r.nextInt(20) + 60, r.nextInt(20) + 60);
            //IDriver driver2 = new DriverImpl(i * 2, "driver" + (i * 2), r.nextInt(20) + 60, r.nextInt(20) + 60, r.nextInt(20) + 60, r.nextInt(20) + 60);
            IDriver driver1 = new DriverImpl(i * 2 - 1, "driver" + (i * 2 - 1), 60, 60, 60, 60);
            IDriver driver2 = new DriverImpl(i * 2, "driver" + (i * 2), 80, 80, 80, 80);
            ITeam team = new TeamImpl(i, "team" + i, car, driver1, driver2);
            driver1.setTeam(team);
            driver2.setTeam(team);
            teams.add(team);
        }

        return teams;
    }

    public ICircuit getCircuit() {
        ArrayList<ICircuitComponent> components = new ArrayList<>();
        components.add(new CircuitComponentStraightImpl(1000));
        components.add(new CircuitComponentCornerImpl(100, 90));
        components.add(new CircuitComponentStraightImpl(1000));
        components.add(new CircuitComponentCornerImpl(100,90));
        components.add(new CircuitComponentStraightImpl(1000));
        components.add(new CircuitComponentCornerImpl(100, 90));
        components.add(new CircuitComponentStraightImpl(1000));
        components.add(new CircuitComponentCornerImpl(100,90));

        //components.add(new CircuitComponentStraightImpl(80000, Direction.LEFT, Direction.RIGHT));

        return new CircuitImpl(2022, "Circuit1", "Country1", 58, components);
    }
}