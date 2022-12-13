package test;

import main.data.ICar;
import main.data.IDriver;
import main.data.ISeason;
import main.data.ITeam;
import main.data.impl.CarImpl;
import main.data.impl.DriverImpl;
import main.data.impl.SeasonImpl;
import main.data.impl.TeamImpl;
import main.race.ICircuit;
import main.race.IRace;
import main.race.impl.CircuitImpl;
import main.race.impl.RaceImpl;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TestSeasonFunction {

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        TestSeasonFunction testSeasonFunction = new TestSeasonFunction();
        testSeasonFunction.run();
    }

    public void run() {
        int year = 2022;
        ArrayList<ITeam> teams = getSomeDefaultTeamData();
        ArrayList<IRace> races = getSomeDefaultRaceData(year, teams);
        ISeason season = new SeasonImpl(year, races, teams);

        while (season.hasNextAction()) {
            System.out.println("What do you want to do?");
            System.out.println("  1. Next action");
            System.out.println("  2. See team leaderboard");
            System.out.println("  3. See driver leaderboard");
            System.out.println();
            System.out.print("Your choice: ");
            String input = scanner.nextLine();
            switch (input) {
                case "1" -> {
                    System.out.println("Next Action: " + season.nextAction());
                    pressEnterToContinue();
                }
                case "2" -> {
                    int placement = 1;
                    for (ITeam team : season.getTeamLeaderboard().getLeaderboard()) {
                        System.out.println(placement + ": " + team.getName() + " - " + team.getPoints());
                        placement++;
                    }
                    pressEnterToContinue();
                }
                case "3" -> {
                    int placement = 1;
                    for (IDriver driver : season.getDriverLeaderboard().getLeaderboard()) {
                        System.out.println(placement + ": " + driver.getName() + " - " + driver.getPoints());
                        placement++;
                    }
                    pressEnterToContinue();
                }
                default -> {
                    System.out.println("Invalid input");
                    pressEnterToContinue();
                }
            }
        }
    }

    public ArrayList<IRace> getSomeDefaultRaceData(int year, ArrayList<ITeam> teams) {
        ArrayList<IRace> races = new ArrayList<>();

        Random random = new Random();
        for (int i = 1; i <= 5; i++) {
            ICircuit circuit = new CircuitImpl(i, "Circuit" + i, "Country" + i, (random.nextInt(30) + 50), null);
            races.add(new RaceImpl(year, circuit, teams));
        }

        return races;
    }

    public ArrayList<ITeam> getSomeDefaultTeamData() {
        ArrayList<ITeam> teams = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            ICar car = new CarImpl(i, "car" + i, 1, 1, 1, 1);
            IDriver driver1 = new DriverImpl(i * 2 - 1, "driver" + (i * 2 - 1), i, 1, 1, 1, 1);
            IDriver driver2 = new DriverImpl(i * 2, "driver" + (i * 2), i, 1, 1, 1, 1);
            teams.add(new TeamImpl(i, "team" + i, car, driver1, driver2));
        }

        return teams;
    }

    public void pressEnterToContinue() {
        System.out.println();
        System.out.println("Press ENTER to continue");
        scanner.nextLine();
    }
}