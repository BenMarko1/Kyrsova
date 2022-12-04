package com.example.kyrsova.based;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static Connection connection;

    /**
     * connecting to the database
     * @return connection
     */
    public static Connection getConnection()  {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                        "postgres", "postgrespw");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }

    /**
     * closing the connection to the database
     */
    public static void closeConnection() {
        try {
            if (connection == null || connection.isClosed()){
                return;
            }
            connection.close();
        } catch (SQLException ignored) {}
    }
}
