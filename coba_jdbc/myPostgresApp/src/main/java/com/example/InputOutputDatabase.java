package com.example;

import java.util.Scanner;
import java.sql.*;

public class InputOutputDatabase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Buat koneksi ke database
            // Connection conn = DriverManager.getConnection(url, user, password);
            Connection conn = PostgresConnection.getConnection();

            // Input data dari pengguna
            System.out.print("Masukkan nama: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan umur: ");
            int umur = scanner.nextInt();

            // Simpan data ke database
            String insertSql = "INSERT INTO students (name, age) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertSql);
            pstmt.setString(1, nama);
            pstmt.setInt(2, umur);
            pstmt.executeUpdate();
            System.out.println("Data berhasil disimpan.");

            // Tampilkan semua data dari tabel
            String selectSql = "SELECT * FROM students";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(selectSql);
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Nama: " + rs.getString("name") + ", Umur: " + rs.getInt("age"));
            }

            // Tutup koneksi dan statement
            rs.close();
            stmt.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}