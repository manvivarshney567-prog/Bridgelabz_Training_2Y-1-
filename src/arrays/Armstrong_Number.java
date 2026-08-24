package arrays;

import java.util.Scanner;

public class Armstrong_Number {
    public static void main(String[] args) {
        int n=153;
        System.out.println(isArmstrong(n));

    }
    public static int count(int n)
    {
        int count =0;
        while(n>0)
        {
            count++;
            n=n/10;
        }
        return count;
    }
    public static boolean isArmstrong(int n)
    {
        int original=n;
        int sum=0;
        int c=count(n);
        original=n;

        while(n>0)
        {
            int digit =n%10;
            sum=sum+(digit*digit*digit);
            n=n/10;

        }
        if(sum==original)
            return true;
        else
            return false;

    }


}
