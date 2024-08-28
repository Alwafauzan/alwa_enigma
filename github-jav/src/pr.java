import java.util.Scanner;

public class pr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();
        int sum = 0;
        int sum2 = 0;
        for (int i = 1; i <=input; i+=2){
            sum += i;
        }
        for (int i = 0; i <=input*2; i+=2){
            sum2 += i;
        }
        System.out.println(sum);
        System.out.println(sum2);
    }
    
}
