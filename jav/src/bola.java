import java.util.Scanner;

public class bola {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);



        Double r = scanner.nextDouble();
        Double phi = 3.14;
        double volume;
        double konstanta1 = 4.0;
        double konstanta2 = 3.0;
        volume = (konstanta1/konstanta2)*phi*r*r*r;

        System.out.println(volume);
    }
    
}
