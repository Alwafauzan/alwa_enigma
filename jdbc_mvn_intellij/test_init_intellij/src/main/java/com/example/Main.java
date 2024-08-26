package com.example;

import com.example.dao.UserDAO;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

        // Create
        userDAO.addUser("John Doe", "john@example.com");
        userDAO.addUser("Jane Smith", "jane@example.com");

        // Read
        List<String> users = userDAO.getAllUsers();
        System.out.println("All Users:");
        for (String user : users) {
            System.out.println(user);
        }

        // Update
        userDAO.updateUser(1, "John Doe Updated", "john_updated@example.com");

        // Delete
        userDAO.deleteUser(2);

        // Read Again
        users = userDAO.getAllUsers();
        System.out.println("\nAll Users After Update and Delete:");
        for (String user : users) {
            System.out.println(user);
        }
    }
}
