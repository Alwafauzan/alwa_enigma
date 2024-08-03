// [CHALLENGE 5.2] Submission Time

import java.util.Scanner;

public class SubmissionTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan jam: ");
        int jamInput = scanner.nextInt();

        if (8 <= jamInput && jamInput <= 17) {
            System.out.println("Success");
        } else {
            System.out.println("Failed");
        } 
        
    }
}