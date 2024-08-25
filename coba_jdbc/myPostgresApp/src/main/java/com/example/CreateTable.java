package com.example;

import java.sql.*;

public class CreateTable {
    public static void main(String[] args) {
        try {
            // Dapatkan koneksi ke database
            Connection conn = PostgresConnection.getConnection();

            // Buat statement SQL untuk membuat tabel
            String sql = "CREATE TABLE IF NOT EXISTS students (" +
                    "id SERIAL PRIMARY KEY," +
                    "name VARCHAR(50)," +
                    "age INT" +
                    ");";

            // Buat objek Statement
            Statement stmt = conn.createStatement();

            // Eksekusi query untuk membuat tabel
            stmt.executeUpdate(sql);
            System.out.println("Tabel 'students' berhasil dibuat.");

            // Tutup koneksi dan statement
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Terjadi kesalahan saat membuat tabel: " + e.getMessage());
        }
    }
}