/**
 * tes
 */
public class tes {

    public static void main(String[] args) {
        int[] hargaA = {1,2,3,4};
        int[] hargaB = {2,2,2,2};

        int minTotal = 100000000;
        int[] pasangan = new int[2];

        for (int i = 0; i < hargaA.length; i++) {
            for (int j = 0; j < hargaB.length; j++) {
                int total = hargaA[i] + hargaB[j];
                if (total < minTotal) {
                    minTotal = total;
                    pasangan[0] = hargaA[i];
                    pasangan[1] = hargaB[j];
                }
            }
        }
        int[] pasanganTerendah = pasangan;
        System.out.println("Pasangan harga terendah adalah [" + pasanganTerendah[0] + ", " + pasanganTerendah[1] + "] dengan total harga " + (pasanganTerendah[0] + pasanganTerendah[1]) + ".");
    }
}