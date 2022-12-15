package main.database.mysql;

public class SQLStatements {
    public static String getAllDefCars() {
        return "SELECT * FROM def_car";
    }

    public static String getAllDefDrivers() {
        return "SELECT * FROM def_driver";
    }

    public static String getAllDefTeams() {
        return "SELECT * FROM def_teams";
    }

    public static String getAllDefTeamsData() {
        return "SELECT * FROM def_team AS t JOIN def_driver_team AS dt ON dt.dt_team_id = t.team_id JOIN def_team_car AS tc ON tc.tc_team_id = t.team_id";
    }

    public static String getDefTeamDriverByTeamID(int teamID) {
        return "SELECT * FROM def_driver_team WHERE team_id = " + teamID;
    }

    public static String getAllDefResults() {
        return "SELECT * FROM result";
    }

    public static String getDriverAndResultDescending() {
        return "SELECT r.*, d.* FROM def_result r JOIN def_driver d ON r.result_driver_id = d.driver_id";
    }

    public static String setTeams() {
        return "UPDATE def_team SET points = ?, myteam =  ?  WHERE team_id = ?";
    }


    public static String getLapByResultDriver(int resultID, int driverID) {
        return "SELECT * FROM def_lap WHERE lap_result_id = " + resultID + " AND lap_driver_id = " + driverID;
    }
}
