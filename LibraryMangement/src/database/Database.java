package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/vishwa";
    private static final String USER = "root";
    private static final String PASSWORD = "310820104115";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("JDBC Driver not found!", e);
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
