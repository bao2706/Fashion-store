package context;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + "\\" + instance + ":" + portNumber + ";databaseName=" + databaseName;
        if (instance == null || instance.trim().isEmpty())
            url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + databaseName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userId, password);
    }

    private final String serverName = "localhost";
    private final String portNumber = "3306";
    private final String databaseName = "shortshop";
    private final String instance = "";
    private final String userId = "root";
    private final String password = "root";

    public static void main(String[] args) {
        try {
            System.out.println(new DBConnect().getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
