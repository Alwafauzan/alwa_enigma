package utils;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseUtils {
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
