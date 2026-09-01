package arrays.SlidingWindow;
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Question1 {
    public static void main(String args[]) {
        int nums[] = {1, 2, 3, 4, 5, 6};
        int size = 3;
        int sum = 0;
        int maxSum = 0;

        for (int i = 0; i < size; i++) {
            sum = sum + nums[i];
        }
        System.out.println(sum);
        for (int i = 1; i <= nums.length - size; i++) {
            sum = sum - nums[i - 1] + nums[i + size - 1];
            System.out.println(sum);
        }
    }
}



