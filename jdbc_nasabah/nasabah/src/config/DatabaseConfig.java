package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {


    public static Connection getConnection() throws SQLException {
        // String DB_URL = System.getenv("DB_URL");
        // String DB_USER = System.getenv("DB_USER");
        // String DB_PASSWORD = System.getenv("DB_PASSWORD");

        String DB_URL = "jdbc:postgresql://localhost:5433/coba_jdbc";
        String DB_USER = "postgres";
        String DB_PASSWORD = "myPassword";
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
