// /**
//  * HackerrankTipeData
//  */
// public class HackerrankTipeData {

//     public static void main(String[] args) {
//         System.out.println(Byte.MIN_VALUE);
//         System.out.println(Byte.MAX_VALUE);
//     }
// }

/**
 * HackerrankTipeData
 */
import java.io.*;
import java.util.*;

public class HackerrankTipeData {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        long x = input.nextLong();
    
            System.out.println(x+" can be fitted in:");
            if(x >= Byte.MIN_VALUE && x <= Byte.MAX_VALUE){                
            System.out.println("* short");
            System.out.println("* int");
            System.out.println("* long");
            System.out.println("* byte");
            }
            else if(x >= Short.MIN_VALUE && x <= Short.MAX_VALUE){
                System.out.println("* short");
                System.out.println("* int");
                System.out.println("* long");
            }
            else if(x >= Integer.MIN_VALUE && x <= Integer.MAX_VALUE){
                System.out.println("* int");
                System.out.println("* long");
            } 
            else if (x >= Long.MIN_VALUE && x <= Long.MAX_VALUE) {
                System.out.println("* long");
            } 
            

        
    }
}
