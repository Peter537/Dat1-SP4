package MySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface IMySQL {
    boolean openConnection(String url, String name, String password);
    boolean openConnection(String IP, String Schema, String name, String password);
    boolean closeConnection();
    ResultSet executeQuery(String query);
    boolean executeChange(PreparedStatement query);

}
