package main.database.MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface IMySQL {
    boolean openConnection(String url, String name, String password) throws SQLException, ClassNotFoundException;
    boolean openConnection(String IP, String Schema, String name, String password) throws SQLException, ClassNotFoundException;
    boolean closeConnection();
    ResultSet executeQuery(String query);
    boolean executeChange(PreparedStatement query);

    Connection getConnection();

}
