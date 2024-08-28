
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InputOutputDatabase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            try ( 
            // Buat koneksi ke database
            // Connection conn = DriverManager.getConnection(url, user, password);
                Connection conn = PostgresConnection.getConnection()) {
                Integer angka;
                do {
                    getRs(conn);
                    
                    System.out.println("1 = create, 2 = update, 3 = delete, 4 = read satu2, 5 = exit");
                    System.out.println("angka :");
                    angka = scanner.nextInt();
                    scanner.nextLine();
                    
                    switch (angka) {
                        case 1 -> {
                            getIstmt(scanner, conn);
                        }
                        case 2 -> {
                            getRowsUpdated(scanner, conn);
                        }
                        case 3 -> {
                            getRowsDeleted(scanner, conn);
                        }
                        case 4 -> {
                            getRs2(scanner, conn);
                        }
                    }
                } while (angka != 5);
                
                
                
                // Tutup koneksi dan statement
                // rs.close();
                // stmt.close();
                // stmt.close();
                // istmt.close();
                // ustmt.close();
                // dstmt.close();
                
                scanner.close();
            }
        } catch (SQLException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }

    private static void getRs2(Scanner scanner, Connection conn) throws SQLException {
        // Input ID data yang akan dianuin
        System.out.print("Masukkan ID yang ingin di-read: ");
        int id = scanner.nextInt();
        
        
        // Tampil data satu2
        String selectSql = "SELECT * FROM product WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(selectSql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            System.out.println("Nama: " + rs.getString("name") + ", Harga: " + rs.getInt("price"));
            System.out.println("-----------------------------------");
        } else {
            System.out.println("Data tidak ditemukan.");
            System.out.println("-----------------------------------");
        }
    }

    private static void getRowsDeleted(Scanner scanner, Connection conn) throws SQLException {
        // Input ID data yang akan dihapus
        System.out.print("Masukkan ID yang ingin dihapus: ");
        int idd = scanner.nextInt();

        // Hapus data
        String deleteSql = "DELETE FROM product WHERE id = ?";
        PreparedStatement dstmt = conn.prepareStatement(deleteSql);
        dstmt.setInt(1, idd);
        int rowsDeleted = dstmt.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("Data berhasil dihapus.");
        } else {
            System.out.println("Data tidak ditemukan.");
        }
    }

    private static void getRowsUpdated(Scanner scanner, Connection conn) throws SQLException {
        // Input data yang akan diupdate
        System.out.print("Masukkan ID yang ingin diupdate: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan nama baru: ");
        String namaBaru = scanner.nextLine().replaceAll("[\"\']","\\$0"); // prevent sql injection
        System.out.print("Masukkan price baru: ");
        int priceBaru = scanner.nextInt();

        // Update data
        String updateSql = "UPDATE product SET name = ?, price = ? WHERE id = ?";
        PreparedStatement ustmt = conn.prepareStatement(updateSql);
        ustmt.setString(1, namaBaru);
        ustmt.setInt(2, priceBaru);
        ustmt.setInt(3, id);
        int rowsUpdated = ustmt.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Data berhasil diupdate.");
        } else {
            System.out.println("Data tidak ditemukan.");
        }
    }

    private static void getIstmt(Scanner scanner, Connection conn) throws SQLException {
        // Input data dari pengguna
        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan price: ");
        int price = scanner.nextInt();

        // Simpan data ke database
        String insertSql = "INSERT INTO product (name, price) VALUES (?, ?)";
        PreparedStatement istmt = conn.prepareStatement(insertSql);
        istmt.setString(1, nama.replaceAll("[\"\']","")); // prevent sql injection
        istmt.setInt(2, price);
        istmt.executeUpdate();
        System.out.println("Data berhasil disimpan.");
    }

    private static void getRs(Connection conn) throws SQLException {
        // Tampilkan semua data dari tabel
            String selectSql = "SELECT * FROM product";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(selectSql);
            while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id") + ", Nama: " + rs.getString("name") + ", price: " + rs.getInt("price"));
            }
    }
}