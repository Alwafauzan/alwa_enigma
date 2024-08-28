import java.util.HashSet;
import java.util.Scanner;

public class Menu1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Program Pencari Nilai Negatif Terbesar Yang Hilang Dalam Array");
        System.out.println("==============================================================");
        System.out.println();

        System.out.print("Input jumlah elemen array: ");
        int n = sc.nextInt();

        int[] array = new int[n];
        System.out.println("Input elemen array: ");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println("Elemen min terbesar yang hilang: " + CariAngka(array));

        sc.close();
    }

    public static int CariAngka(int[] array) {
        HashSet<Integer> set = new HashSet<>();
        int maxNegative = Integer.MIN_VALUE;

//         Input semua elemen dan cari elemen min terbesar

        for (int num : array) {
            if (num < 0 && num > maxNegative) {
                maxNegative = num;
            }
            set.add(num);
        }
//          Elemen min terbesar dan cari elemen yang hilang

        for (int i = maxNegative; i < 0; i--) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return maxNegative - 1;
    }
}




