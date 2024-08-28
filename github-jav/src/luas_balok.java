import java.util.Scanner;

public class luas_balok {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double p = scanner.nextDouble();
        double l = scanner.nextDouble();
        double t = scanner.nextDouble();
        double volume;
        double luas;
        volume = p*l*t;
        luas = (p*l)*2+(p*t)*2+(l*t)*2; 
        System.out.println(luas);
        System.out.println(volume);
    }
}
