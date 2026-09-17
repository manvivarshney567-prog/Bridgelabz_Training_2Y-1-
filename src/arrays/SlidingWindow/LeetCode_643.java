package arrays.SlidingWindow;

public class LeetCode_643 {
    public static double findMaxAverage(int[] nums, int k) {

        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum = sum + nums[i];
        }

        int max = sum;

        for (int i = 1; i <= nums.length - k; i++) {
            sum = sum - nums[i - 1] + nums[i + k - 1];
            max = Math.max(sum, max);
        }

        return (double) max / k;
    }

    public static void main(String[] args) {

        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;

        double answer = findMaxAverage(nums, k);

        System.out.println(answer);
    }

}
