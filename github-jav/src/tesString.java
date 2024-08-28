import java.util.Scanner;

public class tesString {

    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("================================");
            for(int i=0;i<3;i++){
                
                String s1=sc.next();
                int x=sc.nextInt();
                int l = 15-s1.length();
                // for (int j=0;j<l;j++){
                // }
                
                // if (x<100){
                //     System.out.printf("%-15s%03d\n",s1,x);
                // }else{
                System.out.printf("%-15s%03d\n",s1,x);}
            // }
            System.out.println("================================");

    }
}



