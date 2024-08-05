package enigma;
import java.util.Scanner;

public class login {
    
    public static void main(String[] args) {
        
        Scanner id = new Scanner(System.in);
        Scanner pw= new Scanner(System.in);
        Scanner act= new Scanner(System.in);
        // scanner.close();
        boolean cekid = id.next().equals("admin");
        boolean cekpw = pw.next().equals("123");
        boolean cekact = act.next().equals("aktif");

        String status = (cekid&&cekpw?(cekid&&cekpw&&cekact? "masuk" : "ga aktif"):"ga masuk");
        System.out.println(status);
    }
    }