import java.util.Arrays;
import java.util.Scanner;

public class Menu2 {



public static int[][] pasanganAngka(int[] arr, int target) {
    int count = 0;
    for (int i = 0; i < arr.length - 1; i++) {
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[i] + arr[j] == target) {
                count++;
            }
        }
    }

    int[][] pasangan = new int[count][2];
    int index = 0;

    for (int i = 0; i < arr.length - 1; i++) {
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[i] + arr[j] == target) {
                pasangan[index][0] = arr[i];
                pasangan[index][1] = arr[j];
                index++;
            }
        }
    }

    return pasangan;
}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("masukkan jumlah index array 1: ");
        int jumlahIndexArray1 = scanner.nextInt();
        int[] arr1 = new int[jumlahIndexArray1];

        System.out.println("masukkan angka array 1: ");
        for (int i = 0; i < jumlahIndexArray1; i++) {
        System.out.print("angka array ke-" + (i+1) + ": ");
        arr1[i] = scanner.nextInt();
}
        // int[] arr1 = {2, 7, 11, 15};
        System.out.println("masukkan target 1");
        int target1 = scanner.nextInt();
        int[][] hasil1 = pasanganAngka(arr1, target1);
        System.out.println("Pasangan untuk " + target1 + ": " + Arrays.deepToString(hasil1));

        System.out.print("masukkan jumlah index array 2: ");
        int jumlahIndexArray2 = scanner.nextInt();
        int[] arr2 = new int[jumlahIndexArray2];

        System.out.println("masukkan angka array 2: ");
        for (int i = 0; i < jumlahIndexArray2; i++) {
        System.out.print("angka array ke-" + (i+1) + ": ");
        arr2[i] = scanner.nextInt();
        // int[] arr2 = {3, 5, 2, -4, 8, 11};
        System.out.println("masukkan target");
        int target2 = scanner.nextInt();
        int[][] hasil2 = pasanganAngka(arr2, target2);
        System.out.println("Pasangan untuk " + target2 + ": " + Arrays.deepToString(hasil2));
    }
}}




