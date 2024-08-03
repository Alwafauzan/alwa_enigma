import java.util.*;
import java.io.*;

class loop_hackerrank{
    public static void main(String []argh){
        Scanner input = new Scanner(System.in);
        // // int t=input.nextInt();
        int ans = 0;
        // // for(int i=0;i<t;i++){
            int a = input.nextInt();
            int b = input.nextInt();
            int n = input.nextInt();
            
            for (int j = 1; j < n+1; j++) {
                ans = a+((int)Math.pow(2, j)) * b - b;
                System.out.print(ans+" ");
            }
        System.out.println();
        // // }
        // in.close();
    }
}
