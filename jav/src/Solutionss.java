import java.util.*;
import java.io.*;

class Solutionsss{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        int ans = 0;
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            for (int j = 1; j < n+1; j++) {
                ans = a+((int)Math.pow(2, j)) * b - b;
                System.out.print(ans+" ");
            }
        System.out.println();
        }
        in.close();
    }
}