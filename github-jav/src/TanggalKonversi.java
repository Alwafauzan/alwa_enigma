import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TanggalKonversi {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int tanggal = scanner.nextInt();
        int bulan = scanner.nextInt();
        int tahun = scanner.nextInt();
        
        String tanggalKonversi = terpaksaBikinMethod(tanggal, bulan, tahun);
        System.out.println(tanggalKonversi);
    }
    
    public static String terpaksaBikinMethod(int tanggal, int bulan, int tahun) {
        switch (bulan) {
            case 1:
                return tanggal + " Januari " + tahun;
            case 2:
                return tanggal + " Februari " + tahun;
            case 3:
                return tanggal + " Maret " + tahun;
            case 4:
                return tanggal + " April " + tahun;
            case 5:
                return tanggal + " Mei " + tahun;
            case 6:
                return tanggal + " Juni " + tahun;
            case 7:
                return tanggal + " Juli " + tahun;
            case 8:
                return tanggal + " Agustus " + tahun;
            case 9:
                return tanggal + " September " + tahun;
            case 10:
                return tanggal + " Oktober " + tahun;
            case 11:
                return tanggal + " November " + tahun;
            case 12:
                return tanggal + " Desember " + tahun;
            default:
                return "Tanggal tidak valid";
        }
    }
}