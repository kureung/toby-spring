package app.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NConnector implements ConnectionManager {

    @Override
    public Connection getConnection() throws SQLException {
        String url = "jdbc:oracle:thin:@127.0.0.1:1521/xe";
        String id = "cho";
        String pw = "0000";
        return DriverManager.getConnection(url, id, pw);
        //eturn DriverManager.getConnection("jdbc:h2:~/test;MODE=mysql","sa","");
    }
}
