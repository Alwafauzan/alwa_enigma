import java.util.Scanner;

public class dasdasd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int length = input.length();
        boolean isPalindrome = true;

        for (int i = 0; i < length / 2; i++) {
            if (input.charAt(i) != input.charAt(length - i - 1)) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println(isPalindrome ? "true" : "false");
    }
}