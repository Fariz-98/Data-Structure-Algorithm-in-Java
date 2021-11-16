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

    // Space complexity optimized
    public static int[] productExceptSelf(int[] nums) {
        int[] outputArray = new int[nums.length];
        outputArray[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            outputArray[i] = nums[i - 1] * outputArray[i - 1];
        }

        // Inout = R = 1 [1, 2, 3, 4] R = 1
        // outputArr = [1, 1, 2, 6]
        // Right product = [24, 12, 4, 1]

        int rightProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            outputArray[i] = outputArray[i] * rightProduct;
            rightProduct = rightProduct * nums[i];
        }

        return outputArray;
    }

    public static int[] productExceptSelfa(int[] nums) {
        int arrLength = nums.length;

        int[] outputArr = new int[arrLength];
        int[] leftProduct = new int[arrLength];
        int[] rightProduct = new int[arrLength];

        leftProduct[0] = 1;
        rightProduct[arrLength - 1] = 1;

        for (int i = 1; i < arrLength; i++) {
            leftProduct[i] = nums[i - 1] * leftProduct[i - 1];
        }

        for (int i = arrLength - 2; i >= 0; i--) {
            rightProduct[i] = nums[i + 1] * rightProduct[i + 1];
        }

        for (int i = 0; i < arrLength; i++) {
            outputArr[i] = leftProduct[i] * rightProduct[i];
        }

        return outputArr;
    }

}
