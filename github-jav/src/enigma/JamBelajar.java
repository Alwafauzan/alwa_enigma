package enigma;
// [CHALLENGE 5.3] Jam Belajar

import java.util.Scanner;

public class JamBelajar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan jam: ");
        int jamInput = scanner.nextInt();

        if ((8 <= jamInput && jamInput <= 12) || (14 <= jamInput && jamInput <= 17)) {
            System.out.println("JAM BELAJAR");
        } else if (0 <= jamInput && jamInput <= 24) {
            System.out.println("JAM ISTIRAHAT");
        } else {
            System.out.println("WAKTU HANYA 24 JAM");
        }
    }
}