import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int angka =0;
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            System.out.println(++angka+" "+input.nextLine());
        }
    }
}