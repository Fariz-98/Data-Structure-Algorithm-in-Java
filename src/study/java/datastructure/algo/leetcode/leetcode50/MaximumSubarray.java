package study.java.datastructure.algo.leetcode.leetcode50;

// 53
// Easy
// TODO: Not accepted, solve using Kadane's Algorithm.

public class MaximumSubarray {

    public static void main(String[] args) {
        int[] arr = {5,4,-1,7,8};

        System.out.println(maxSubArray(arr));
    }

    public static int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = currentSum;

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

}
