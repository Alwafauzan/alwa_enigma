/**
 * array
 */
public class array {

    public static void main(String[] args) {

        int[] numbers = {1, 5, 2, 8, 3, 9};
        for (int i : numbers) {
            if (i % 2 == 0) {
                
                System.out.println(i);
            }
        }

        for (int i = 0; i<=3; i++){
            for (int j = 0; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}