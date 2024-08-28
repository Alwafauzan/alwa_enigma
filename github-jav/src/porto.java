import java.util.Scanner;

public class porto {
        public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("nama");
        String nama = scanner.nextLine();

        System.out.println("umur");
        Integer umur = scanner.nextInt();

        System.out.println("jumlah invest");
        Long jumlahInvest = scanner.nextLong();

        Scanner a = new Scanner(System.in);
        
        System.out.println("nama perusahaah");
        String namaPerusahaan = a.nextLine();

        System.out.println("porto");
        System.out.println("nama : "+nama);
        System.out.println("umur : "+umur);
        System.out.println("jumlah investasi : Rp."+jumlahInvest);
        System.out.println("nama perusahaan :"+namaPerusahaan);

    }
}
