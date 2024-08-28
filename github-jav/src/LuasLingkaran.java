import java.util.Scanner; 
public class LuasLingkaran{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double phi = 3.14;
        double jari = scanner.nextInt();
        
        System.out.println(phi * (jari * jari));
    }