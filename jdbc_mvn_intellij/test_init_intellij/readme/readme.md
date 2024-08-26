# init project

## bikin project

1. bikin project baru
   ![project baru](./Screenshot%20from%202024-08-26%2019-16-00.png)
2. pilih maven
   ![pilih maven](./Screenshot%20from%202024-08-26%2019-18-06.png)
3. masuk ke pom.xml terus copas ini

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>
    <artifactId>jdbc-crud</artifactId>
    <version>1.0-SNAPSHOT</version>

    <dependencies>
        <!-- PostgreSQL JDBC Driver -->
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <version>42.2.23</version>
        </dependency>

        <!-- JUnit for testing (optional) -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.2</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.1</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>

```

4. bikin db

```terminal
sudo -i -u postgres
createdb jdbc_crud_db
psql jdbc_crud_db
```

```sql
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100)
);
```

5. bikin package baru di dalam src/main/java namanya "com.example.util" terus bikin class "DatabaseUtil.java"

```java
package com.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    private static final String URL = "jdbc:postgresql://localhost:5432/jdbc_crud_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
    }
}
```

6. bikin package baru di src/main/java dengan nama "com.example.dao".bikin class "UserDAO.java".

```java
package com.example.dao;

import com.example.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    // Create
    public void addUser(String name, String email) {
        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, email);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read
    public List<String> getAllUsers() {
        List<String> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Connection connection = DatabaseUtil.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                users.add(resultSet.getString("name") + " - " + resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    // Update
    public void updateUser(int id, String name, String email) {
        String sql = "UPDATE users SET name = ?, email = ? WHERE id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setInt(3, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteUser(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

7. bikin kelas "Main.java" di dalam package "com.example"

```java
package com.example;

import com.example.dao.UserDAO;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

        // Create
        userDAO.addUser("a", "a@a.com");
        userDAO.addUser("b", "b@b.com");

        // Read
        List<String> users = userDAO.getAllUsers();
        System.out.println("All Users:");
        for (String user : users) {
            System.out.println(user);
        }

        // Update
        userDAO.updateUser(1, "a Updated", "a@a.com");

        // Delete
        userDAO.deleteUser(2);

        // Read
        users = userDAO.getAllUsers();
        System.out.println("\nAll User Update Delete:");
        for (String user : users) {
            System.out.println(user);
        }
    }
}

```

## semua file

![semua file](./Screenshot%20from%202024-08-26%2020-18-01.png)
