package test;

import main.data.ITeam;
import main.database.DataBaseIO;
import main.race.ICircuit;
import main.race.IRace;
import main.race.impl.CircuitImpl;
import main.race.impl.RaceImpl;

import java.util.ArrayList;

public class TestRaceFunction {

    public static void main(String[] args) {
        DataBaseIO.initSQL(false, null);
        ArrayList<ITeam> teams = DataBaseIO.loadDefaultTeamData();

        ICircuit circuit1 = new CircuitImpl(1, "Circuit1", "Country1", 58, null);
        ICircuit circuit2 = new CircuitImpl(2, "Circuit2", "Country2", 62, null);
        ICircuit circuit3 = new CircuitImpl(3, "Circuit3", "Country3", 71, null);
        ICircuit circuit4 = new CircuitImpl(4, "Circuit4", "Country4", 65, null);

        IRace race1 = new RaceImpl(1, circuit1, teams);
        IRace race2 = new RaceImpl(1, circuit2, teams);
        IRace race3 = new RaceImpl(1, circuit3, teams);
        IRace race4 = new RaceImpl(1, circuit4, teams);
        
        race1.nextAction();
        race1.nextAction();
        race1.nextAction();
    }
}