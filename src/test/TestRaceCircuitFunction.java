package test;

import main.data.ICar;
import main.data.IDriver;
import main.data.ITeam;
import main.data.impl.CarImpl;
import main.data.impl.DriverImpl;
import main.data.impl.TeamImpl;
import main.enums.Direction;
import main.race.ICircuit;
import main.race.IRace;
import main.race.circuit.CircuitComponentCornerImpl;
import main.race.circuit.CircuitComponentStraightImpl;
import main.race.circuit.ICircuitComponent;
import main.race.impl.CircuitImpl;
import main.race.impl.RaceImpl;

import java.util.ArrayList;

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

        java.util.Random r = new java.util.Random();

        // create 10 teams in total
        for (int i = 1; i <= 10; i++) {
            ICar car = new CarImpl(i, "car" + i, r.nextInt(50) + 1000, r.nextInt(50) + 1000, r.nextDouble(0.1) + 0.1, r.nextDouble(0.1) + 0.1);
            IDriver driver1 = new DriverImpl(i * 2 - 1, "driver" + (i * 2 - 1), i, 1, 1, 1, 1);
            IDriver driver2 = new DriverImpl(i * 2, "driver" + (i * 2), i, 1, 1, 1, 1);
            teams.add(new TeamImpl(i, "team" + i, car, driver1, driver2));
        }

        return teams;
    }

    public ICircuit getCircuit() {
        ArrayList<ICircuitComponent> components = new ArrayList<>();
        components.add(new CircuitComponentStraightImpl(1000, Direction.LEFT, Direction.RIGHT));
        components.add(new CircuitComponentCornerImpl(100, 90, Direction.RIGHT, Direction.DOWN));
        components.add(new CircuitComponentStraightImpl(1000, Direction.UP, Direction.DOWN));
        components.add(new CircuitComponentCornerImpl(100,90, Direction.DOWN, Direction.LEFT));
        components.add(new CircuitComponentStraightImpl(1000, Direction.RIGHT, Direction.LEFT));
        components.add(new CircuitComponentCornerImpl(100, 90, Direction.LEFT, Direction.UP));
        components.add(new CircuitComponentStraightImpl(1000, Direction.DOWN, Direction.UP));
        components.add(new CircuitComponentCornerImpl(100,90, Direction.UP, Direction.RIGHT));

        //components.add(new CircuitComponentStraightImpl(80000, Direction.LEFT, Direction.RIGHT));

        return new CircuitImpl(2022, "Circuit1", "Country1", 58, components);
    }
}