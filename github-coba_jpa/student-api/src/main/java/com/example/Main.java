package com.example;

import java.util.List;

import com.example.controller.StudentController;
import com.example.model.Student;

public class Main {
    public static void main(String[] args) {
        StudentController studentController = new StudentController();

        System.out.println(System.getenv("DB_USER"));
        int pilihan = 0;
        while (pilihan != 5) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambahkan data siswa");
            System.out.println("2. Mendapatkan semua data siswa");
            System.out.println("3. Mengupdate data siswa");
            System.out.println("4. Menghapus siswa");
            System.out.println("5. Keluar");
            System.out.print("Pilihan: ");
            pilihan = Integer.parseInt(System.console().readLine());

            switch (pilihan) {
                case 1:
                    String nama = System.console().readLine("Nama: ");
                    String jurusan = System.console().readLine("Jurusan: ");
                    studentController.createStudent(nama, jurusan);
                    break;
                case 2:
                    List<Student> students = studentController.getAllStudents();
                    System.out.println("Daftar Siswa:");
                    for (Student student : students) {
                        System.out.println(
                                "ID: " + student.getId() + ", Nama: " + student.getNama() + ", Jurusan: "
                                        + student.getJurusan());
                    }
                    break;
                case 3:
                    int id = Integer.parseInt(System.console().readLine("ID: "));
                    String namaBaru = System.console().readLine("Nama baru: ");
                    String jurusanBaru = System.console().readLine("Jurusan baru: ");
                    studentController.updateStudent(id, namaBaru, jurusanBaru);
                    break;
                case 4:
                    int idHapus = Integer.parseInt(System.console().readLine("ID: "));
                    studentController.deleteStudent(idHapus);
                    break;
                case 5:
                    System.out.println("Terima kasih");
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        }
    }
}
