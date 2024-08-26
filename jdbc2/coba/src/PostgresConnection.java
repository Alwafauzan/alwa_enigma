
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnection {
    private static final String DB_URL = System.getenv("jdbc:postgresql://localhost:5433/coba_jdbc");
    private static final String DB_USER = System.getenv("postgres");
    private static final String DB_PASSWORD = System.getenv("myPassword");

        // String url = "jdbc:postgresql://localhost:5433/coba_jdbc";
        // String user = "postgres";
        // String password = "myPassword";
    static {
        if (DB_URL == null || DB_USER == null || DB_PASSWORD == null) {
            throw new IllegalStateException("The url, user, password cannot be null");
        }
    }

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            return conn;
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC driver not found.");
            // e.printStackTrace();
            return null;
        }
    }
}