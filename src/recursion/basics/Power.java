package recursion.basics;

import java.util.Scanner;

public class Power {
    public static int pow(int p,int q){
        if(q==0){
            return 1;
        }
        return p * pow(p, q - 1);
    }
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        System.out.print("Enetr base:");
        int p=sc.nextInt();
        System.out.print("Enter power:");
        int q=sc.nextInt();
        System.out.println(pow(p,q));
    }

}
