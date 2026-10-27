package recursion.basics;

import static recursion.basics.Factorial.fact;

public class Fibonacci {
    public static int fib(int n){
        if(n==0){
            return 0;
        }
        if(n==1) {
            return 1;
        }
        int small1=fact(n-1);
        int small2=fact(n-2);
        return small1+small2;
    }
    public static void main(String args []){
        System.out.println(fact(5));
    }

}
