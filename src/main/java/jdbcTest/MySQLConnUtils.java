package jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnUtils {
    public static Connection getMySQLConnection() {
        String hostName = "";
        String dbName = "";
        String userName = "";
        String password = "";
        return getMySQLConnection(hostName,dbName, userName, password);
    }
    private static Connection getMySQLConnection(String hostName, String dbName, String userName, String password) {
        Connection conn = null;
        try {
            String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
            conn = DriverManager.getConnection(connectionURL, userName,password);
        } catch (Exception e) {
            e.printStackTrace();
        } return conn;
    }
}
