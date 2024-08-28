import java.util.Scanner;

public class LoopJavDev {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int angka = input.nextInt();
        for (int i = angka; i >= 1; i--) {
            System.out.println(i + " - \"I will become a java developer\"");
        }
    }
}