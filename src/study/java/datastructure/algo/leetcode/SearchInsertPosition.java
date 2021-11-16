package study.java.datastructure.algo.leetcode;

// 35
// Easy

public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(searchInsertIterative(nums, 0));
    }

    public static int searchInsertIterative(int[] nums, int target) {
        int indexTrack = 0;

        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i])
                return i;

            if (nums[i] > target) {
                indexTrack = i;
                break;
            }

            if (i == nums.length - 1) {
                indexTrack = i + 1;
                break;
            }
        }

        return indexTrack;
    }

}
