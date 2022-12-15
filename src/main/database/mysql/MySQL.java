package main.database.mysql;

import java.sql.*;

public class MySQL implements IMySQL {

    private Connection con;

    @Override
    public boolean openConnection(String url, String name, String password) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        //Example: "jdbc:mysql://localhost:/world", "root", "12321"
        con = DriverManager.getConnection("jdbc:mysql://" + url + "?autoReconnect=true&useSSL=false", name, password);
        return true;
    }

    @Override
    public boolean openConnection(String IP, String schema, String name, String password) throws SQLException, ClassNotFoundException {
//
//        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Example: "jdbc:mysql://localhost:/world", "root", "12321"
            con = DriverManager.getConnection("jdbc:mysql://" + IP + ":/" + schema + "?autoReconnect=true&useSSL=false", name, password);
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//            return false;
//        }
        return true;
    }

    @Override
    public boolean closeConnection() {
        try {
            con.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ResultSet executeQuery(String query) {
        try {
            return con.createStatement().executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean executeChange(PreparedStatement query) {
        try {
            query.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Connection getConnection() {
        return con;
    }
}