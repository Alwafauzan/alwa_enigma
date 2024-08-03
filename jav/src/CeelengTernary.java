public class CeelengTernary {
    public static void main(String[] args) {
        String bonus;
        int pendapatan = 9000;
        int keanggotaan = 6;

        
        bonus = (pendapatan <= 8000 && keanggotaan <= 2) ? "Pupuk" :
                (pendapatan <= 8000 && keanggotaan > 2) ? "Pupuk dan Bibit" :
                (pendapatan > 8000 && keanggotaan <= 2) ? "Bibit" :
                "Bibit dan Alat";
        
        System.out.println("Bonus yang didapatkan: " + bonus);
        

    }
}
