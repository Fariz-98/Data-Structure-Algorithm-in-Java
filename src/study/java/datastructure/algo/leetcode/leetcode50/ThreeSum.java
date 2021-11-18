package study.java.datastructure.algo.leetcode.leetcode50;

// 15
// Medium

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        int[] nums2 = {-2,0,1,1,2};
        int[] nums3 = {0,0,0,0};

        System.out.println(threeSum(nums3));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        List<List<Integer>> returningList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int target = 0 - nums[i];

            Set<List<Integer>> setList = twoSumUsingPointers(Arrays.copyOfRange(nums, i + 1, nums.length), target, nums[i]);

            if (!setList.isEmpty()) {
                for (List<Integer> tempList : setList) {
                    returningList.add(new ArrayList<>(tempList));
                }
            }
        }

        return new ArrayList<>(returningList);
    }

    public static Set<List<Integer>> twoSumUsingPointers(int[] nums, int target, int curr) {
        int lowPointer = 0;
        int highPointer = nums.length - 1;
        int currentSum = 0;
        Set<List<Integer>> setList = new HashSet<>();

        while (lowPointer < highPointer) {
            currentSum = nums[lowPointer] + nums[highPointer];

            if (currentSum > target) {
                highPointer--;
            } else if (currentSum < target) {
                lowPointer++;
            } else if (currentSum == target) {
                setList.add(new ArrayList<>(Arrays.asList(curr, nums[lowPointer], nums[highPointer])));
                lowPointer++;
                highPointer--;
            }
        }

        return setList;
    }

}
