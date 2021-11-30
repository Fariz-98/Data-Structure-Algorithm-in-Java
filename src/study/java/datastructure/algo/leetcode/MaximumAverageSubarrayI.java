package study.java.datastructure.algo.leetcode;

// 643
// Easy

public class MaximumAverageSubarrayI {

    public static void main(String[] args) {

    }

    public static double findMaxAverage(int[] nums, int k) {
        int start = 0;
        int end = 0;
        double average = Integer.MIN_VALUE;
        double currSum = 0.0;

        while (end < nums.length) {
            if ((end - start + 1) < k) {
                currSum += nums[end];
                end++;
            } else {
                currSum += nums[end];
                average = Math.max(average, currSum / k);
                currSum -= nums[start];
                start++;
                end++;
            }
        }

        return average;
    }

}
