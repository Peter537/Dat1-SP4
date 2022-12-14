package main.database;

import main.FormulaOne;
import main.data.ICar;
import main.data.IDriver;
import main.data.ITeam;
import main.data.IUser;
import main.data.impl.CarImpl;
import main.data.impl.DriverImpl;
import main.data.impl.TeamImpl;
import main.data.impl.UserImpl;
import main.database.MySQL.*;
import main.race.IDriverResult;
import main.race.ILap;
import main.race.IRace;
import main.race.IRaceResult;
import main.race.impl.DriverResultImpl;
import main.race.impl.LapImpl;
import main.race.impl.RaceImpl;
import main.race.impl.RaceResultImpl;

import java.io.File;
import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class DataBaseIO {
    private static String DatabaseName = "formula1manager";
    private static IMySQL mySQL;
    private static ArrayList<IDriver> cachedDrivers;
    private static ArrayList<ICar> cachedCars;
    private static ArrayList<ITeam> cachedTeams;

    private static FormulaOne formulaOne;


    public static void initSQL(boolean isNewSave, FormulaOne _formulaOne) {
        mySQL = new MySQL();
        formulaOne = _formulaOne;

        boolean isConnected = false;

        System.out.println("Attempting to connect to database...");

        try {
            isConnected = mySQL.openConnection("localhost", DatabaseName, "root", getPassword());
            DataBaseIO.loadDefaultTeamData();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to connect to database. Exiting...");
            System.exit(0);
        }

        System.out.println("Connected to database!");
    }

    public static void saveNewTeam(FormulaOne formulaOne) {
        System.out.println(formulaOne.getSessionCache().getCurrentUser().getTeam());
    }
    // write a method that saves all the data to the database
    public static void saveData(FormulaOne formulaOne) {
    try {

        // save drivers
        for (IDriver driver : cachedDrivers) {
            if (cachedDrivers.contains(driver)) {

               // "UPDATE def_team SET team_points = ?, myteam =  ?  WHERE team_id = ?"

                PreparedStatement statement = mySQL.getConnection().prepareStatement("UPDATE def_driver SET points = ? WHERE driver_id = ?");
                statement.setInt(1, driver.getPoints());
                statement.setInt(2, driver.getID());

                mySQL.executeChange(statement);
            }
        }
        // save cars
        for (ICar car : cachedCars) {

        }
        // save teams
        for (ITeam team : cachedTeams) {
            if (cachedTeams.contains(team)) {

                PreparedStatement statement = mySQL.getConnection().prepareStatement(SQLStatements.setTeams());
                statement.setInt(1, team.getPoints());

                if (team.getID() == formulaOne.getSessionCache().getCurrentUser().getTeam().getID()) {
                    statement.setInt(2, 1);
                } else {
                    statement.setInt(2,0);
                }
                statement.setInt(3, team.getID());

                mySQL.executeChange(statement);
            }
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
                int myTeam = rs.getInt("myteam");

                ICar car = null;
                car = cachedCars.stream().filter(c -> c.getID() == carID).findFirst().orElse(null);
                IDriver driver1 = null;
                driver1 = cachedDrivers.stream().filter(d -> d.getID() == driver1ID).findFirst().orElse(null);
                IDriver driver2 = null;
                driver2 = cachedDrivers.stream().filter(d -> d.getID() == driver2ID).findFirst().orElse(null);

                ITeam team = new TeamImpl(teamId, teamName, car, driver1, driver2);

                if (myTeam == 1) {
                    IUser user = new UserImpl(team);
                    formulaOne.getSessionCache().setCurrentUser(user);
                }

//                team.addPoints(teamPoints);
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
        IDriver driver = null;
        ArrayList<IDriverResult> tempResult = new ArrayList<>();
        int tempID = -1;
        IRace tempRace = null;

        try {
            ResultSet rs = mySQL.executeQuery(SQLStatements.getAllDefResults());

            while (rs.next()) {
                String name = rs.getString("name");
                int id = rs.getInt("id");
                int circuitID = rs.getInt("circuit_id");
                int year = rs.getInt("year");

                int resultDriverId = rs.getInt("result_driver_id");
                driver = cachedDrivers.stream().filter(d -> d.getID() == resultDriverId).findFirst().orElse(null);

                int placement = rs.getInt("placement");
                int crashed = rs.getInt("crashed");

                if (tempID == id) {
                    IDriverResult driverResult = loadDriverResult(driver, tempRace, id);
                    driverResult.setPlacement(placement);
                    driverResult.setHasCrashed(crashed == 1);
                    tempResult.add(driverResult);
                }
                else {
                    if (tempResult.size() != 0) {
                        raceResults.add(new RaceResultImpl(tempResult, null));
                        tempResult = new ArrayList<>();
                    }

                    tempRace = new RaceImpl(year, null, null); //TODO: Look-up in circuit and figure out how to list teams

                    IDriverResult driverResult = loadDriverResult(driver, tempRace, id);
                    driverResult.setPlacement(placement);
                    driverResult.setHasCrashed(crashed == 1);
                    tempResult.add(driverResult);
                }

                tempID = id;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return raceResults;
    }

    private static IDriverResult loadDriverResult(IDriver driver, IRace race, int resultID) {
        ArrayList<ILap> laps = loadLapData(resultID, race, driver);
        return new DriverResultImpl(race, driver, laps, false);
    }

    private static ArrayList<ILap> loadLapData(int resultID, IRace race, IDriver driver) {
        ArrayList<ILap> laps = new ArrayList<>();

        try {
            ResultSet rs = mySQL.executeQuery(SQLStatements.getLapByResultDriver(resultID, driver.getID()));

            while (rs.next()) {
                int lapNumber = rs.getInt("lap_number");
                float lapTime = rs.getFloat("lap_time");

                ILap lap = new LapImpl(race, driver, lapNumber, lapTime);
                laps.add(lap);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return laps;
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