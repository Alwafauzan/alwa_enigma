import java.util.Arrays;

public class max {
    public static void main(String[] args) {
        int[] numbers = {1, 5, 2, 8, 3, 9};
        int max = Arrays.stream(numbers).max().getAsInt();
        System.out.println("Maximum value: " + max);
    }
}