package main.database;

import main.FormulaOne;
import main.data.ICar;
import main.data.IDriver;
import main.data.ITeam;
import main.data.impl.CarImpl;
import main.data.impl.DriverImpl;
import main.data.impl.TeamImpl;
import main.database.MySQL.*;
import main.race.IRaceResult;
import main.race.impl.RaceResultImpl;

import java.io.File;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class DataBaseIO {
    private static String DatabaseName = "formula1manager";
    private static IMySQL mySQL;
    private static ArrayList<IDriver> cachedDrivers;
    private static ArrayList<ICar> cachedCars;
    private static ArrayList<ITeam> cachedTeams;

    public static void initSQL(boolean isNewSave, FormulaOne formulaOne) {
        mySQL = new MySQL();

        boolean isConnected = false;

        System.out.println("Attempting to connect to database...");

        try {
            isConnected = mySQL.openConnection("localhost", DatabaseName, "root", getPassword());
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to connect to database. Exiting...");
            System.exit(0);
        }

        System.out.println("Connected to database!");
    }
    public static void saveData() {

    }
    public static void newSave() {

    }

    public static ArrayList<ITeam> loadDefaultTeamData() {
        ArrayList<ITeam> teams = new ArrayList<>();
        if (cachedCars == null || cachedCars.isEmpty()) {
            cachedCars = loadDefaultCarData();
        }
        if (cachedDrivers == null || cachedDrivers.isEmpty()) {
            cachedDrivers = loadDefaultDriverData();
        }
        try {
            ResultSet rs = mySQL.executeQuery(SQLStatements.getAllDefTeamsData());

            while (rs.next()) {
                int teamId = rs.getInt("team_id");
                String teamName = rs.getString("team_name");
                int teamPoints = rs.getInt("team_points");
                int carID = rs.getInt("tc_car_id");
                int driver1ID = rs.getInt("dt_driver1_id");
                int driver2ID = rs.getInt("dt_driver2_id");

                ICar car = null;
                car = cachedCars.stream().filter(c -> c.getID() == carID).findFirst().orElse(null);
                IDriver driver1 = null;
                driver1 = cachedDrivers.stream().filter(d -> d.getID() == driver1ID).findFirst().orElse(null);
                IDriver driver2 = null;
                driver2 = cachedDrivers.stream().filter(d -> d.getID() == driver2ID).findFirst().orElse(null);

                ITeam team = new TeamImpl(teamId, teamName, car, driver1, driver2);
                teams.add(team);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        if (cachedTeams == null)
            cachedTeams = teams;
        return teams;
    }
    public static ArrayList<IDriver> loadDefaultDriverData() {
        ArrayList<IDriver> drivers = new ArrayList<>();

        try {
            ResultSet rs = mySQL.executeQuery(SQLStatements.getAllDefDrivers());

            while (rs.next()) {
                int driverId = rs.getInt("driver_id");
                String name = rs.getString("name");
                int points = rs.getInt("points");
                int experience = rs.getInt("experience");
                int cornering = rs.getInt("cornering");
                int consistency = rs.getInt("consistency");
                int acceleration = rs.getInt("acceleration");

                IDriver driver = new DriverImpl(driverId, name, points, experience, cornering, consistency, acceleration);
                drivers.add(driver);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        if (cachedDrivers == null)
            cachedDrivers = drivers;
        return drivers;
    }
    public static ArrayList<ICar> loadDefaultCarData() {
        ArrayList<ICar> cars = new ArrayList<>();

        try {
            ResultSet rs = mySQL.executeQuery(SQLStatements.getAllDefCars());

            while (rs.next()) {
                int carId = rs.getInt("car_id");
                String name = rs.getString("name");
                int horsepower = rs.getInt("horsepower");
                int weight = rs.getInt("weight");
                double aerodynamics = rs.getDouble("aerodynamics");
                double tirepressure = rs.getDouble("tirepressure");

                ICar car = new CarImpl(carId, name, horsepower, weight, aerodynamics, tirepressure);
                cars.add(car);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        if (cachedCars == null)
            cachedCars = cars;
        return cars;
    }
    public static ArrayList<IRaceResult> loadRaceData() {
        ArrayList<IRaceResult> raceResults = new ArrayList<>();

        try {
            ResultSet rs = mySQL.executeQuery(SQLStatements.getAllDefResults());

            while (rs.next()) {
                int resultId = rs.getInt("result_id");
                String name = rs.getString("name");
                int id = rs.getInt("id");
                int resultDriverId = rs.getInt("result_driver_id");
                int placement = rs.getInt("placement");
                float time = rs.getFloat("time");
                int isqual = rs.getInt("isqual");
                int crashed = rs.getInt("crashed");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return raceResults;
    }

    private static String getPassword() {
        File file = new File("Data/databasepassword.txt");
        try {
            Scanner scanner = new Scanner(file);
            return scanner.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}