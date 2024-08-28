import java.util.Scanner;

public class FaktorBilangan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int angka = input.nextInt();

        // System.out.print("Faktor dari " + angka + " adalah: ");
        for (int i = 1; i <= angka; i++) {
            if (angka % i == 0) {
                System.out.print(i + " ");
            }
        }
    }
}