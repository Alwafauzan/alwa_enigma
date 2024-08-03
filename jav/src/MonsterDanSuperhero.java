// [CHALLENGE - 5.4] Monster dan Superhero

import java.util.Scanner;

public class MonsterDanSuperhero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nama: ");
        String name = scanner.nextLine();

        System.out.print("Masukkan peran (Superhero/Monster): ");
        String role = scanner.nextLine();

        if (name.isEmpty() || role.isEmpty()) {
            System.out.println("Nama dan Peran Harus Di Isi");
        } else if (role.equals("Superhero")) {
            System.out.println("Selamat Datang Superhero " + name + ", Kalahkan Semua Monster Di Muka Bumi");
        } else if (role.equals("Monster")) {
            System.out.println("Selamat Datang Monster " + name + ", Hancurkan Semua Superhero Yang Ada");
        } else {
            System.out.println("Selamat Datang " + name + ", Pilih Peranmu Untuk Melanjutkan Game Ini");
        }
    }
}