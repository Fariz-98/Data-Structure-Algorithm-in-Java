package study.java.datastructure.algo.leetcode.leetcode50;

// 153
// Medium

public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        int[] first = {4, 5, 6, 7, 0, 1 ,2};
        int[] second = {3, 4, 5, 1, 2};
        int[] third = {3, 4, 5, 6, 7, 8, 0, 1, 2};
        int[] pat = {2, 1};
        int[] limo = {0, 1, 2, 4, 5, 6, 7};

        System.out.println(findMind(first));
    }

    public static int findMind(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int middle = low + (high - low) / 2;

            if (middle > 0 && nums[middle] < nums[middle - 1]) {
                return nums[middle];
            } else if (nums[middle] > nums[high]) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        return nums[low];
    }

}
