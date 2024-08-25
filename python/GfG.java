
// A Java program to print 2D array using deepToString() 
import java.util.Arrays; 
  
public class GfG 
{ 
    public static void main(String[] args) 
    { 
        // Create a 2D array 
        int[][] mat = new int[2][2]; 
        mat[0][0] = 99; 
        mat[0][1] = 151; 
        mat[1][0] = 30; 
        mat[1][1] = 5; 
  
        // print 2D integer array using deepToString() 
        System.out.println((mat)); 
        System.out.println(Arrays.deepToString(mat)); 
    } 
} 
