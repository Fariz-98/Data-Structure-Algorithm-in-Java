package study.java.datastructure.algo.leetcode.todo.notaccepted;

// 53
// Easy
// TODO: Not accepted, solve using DP.

public class MaximumSubarray {

    public static void main(String[] args) {
        int[] arr = {5,4,-1,7,8};

        System.out.println(maxSubArray(arr));
    }

    public static int maxSubArray(int[] nums) {
        int iteration = 1;
        int largestSum = Integer.MIN_VALUE;

        while (iteration <= nums.length) {
            int startIndex = 0;
            int endIndex = iteration - 1;

            while (endIndex <= nums.length - 1) {
                int sum = 0;
                for (int i = startIndex; i <= endIndex; i++) {
                    sum += nums[i];
                }

                if (sum > largestSum) {
                    largestSum = sum;
                }

                startIndex++;
                endIndex++;
            }

            iteration++;
        }
        return largestSum;
    }

}
