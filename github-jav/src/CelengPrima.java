/**
 * celengbaru
 */
public class CelengPrima {

    public static void main(String[] args) {

        int number = 7;
        
        if (number <= 1) {
            System.out.println("bukan bilangan prima");
        }
        
        boolean isPrime = true;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }
        
        String result = isPrime ? "bilangan prima" : "bukan bilangan prima";
        System.out.println(result);
    }
}