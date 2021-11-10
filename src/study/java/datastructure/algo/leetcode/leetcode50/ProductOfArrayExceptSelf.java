package study.java.datastructure.algo.leetcode.leetcode50;

// 238
// Medium

// TODO:

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        for (Integer tempInt : productExceptSelf(nums))
            System.out.println(tempInt);
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] product = new int[nums.length];
        int[] passed = new int[nums.length];

        int calculateAll = nums[0];
        for (int i = 1; i < nums.length; i++) {
            calculateAll *= nums[i];
        }

        product[0] = calculateAll;

        int currentProduct = nums[0];
        int j = 1;

        for (int i = 1; i < nums.length; i++) {
            product[j] = nums[i] * currentProduct;
            currentProduct = nums[i];
            j++;
        }

        return product;
    }

}
