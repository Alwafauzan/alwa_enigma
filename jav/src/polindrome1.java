
public class polindrome1 {
    public static void main(String[] args) {
        String input = "madam";


        int length = input.length();
        boolean isPalindrome = true;

        for (int i = 0; i < length / 2; i++) {
            // System.out.println(input.charAt(i));
            System.out.println(input.charAt(length - i - 1));
            // if (input.charAt(i) != input.charAt(length - i - 1)) {
                // isPalindrome = false;
                // break;
            }
        // }

        // System.out.println(isPalindrome ? "true" : "false");
    }}
   

