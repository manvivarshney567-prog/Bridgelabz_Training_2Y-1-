package Strings.Leetcode;
import java.util.Scanner;
public class Leetcode_11 {
    public int maxArea(int[] height) {

        int start = 0;
        int end = height.length - 1;
        int max = 0;

        while (start < end) {

            int width = end - start;
            int h = Math.min(height[start], height[end]);
            int area = width * h;

            max = Math.max(max, area);

            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }

        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }
        Leetcode_11 obj = new Leetcode_11();
        System.out.println(obj.maxArea(height));
    }
}

