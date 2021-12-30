package study.java.datastructure.algo.leetcode;

// 152
// Medium

public class MaximumProductSubarray {

    public static void main(String[] args) {
        int[] test = {2,3,-2,4};
        int[] test1 = {-2,0,-1};
        int[] test2 = {-2};

        System.out.println(maxProduct(test2));
    }

    public static int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;

        int prefix = 1;
        int suffix = 1;

        int end = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            prefix *= nums[i];
            suffix *= nums[end];

            if (prefix == 0) prefix = 1;
            if (suffix == 0) suffix = 1;

            res = Math.max(res, Math.max(prefix, suffix));

            end--;
        }

        return res;
    }

}
