package study.java.datastructure.algo.leetcode.leetcode50;

// 1
// Easy

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {3,2,4};

        for (int tempInt : twoSum(nums, 6)) {
            System.out.println();
            System.out.println(tempInt);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        List<Integer> numList = new ArrayList<>();
        int[] index = new int[2];

        for (Integer tempInt : nums) {
            numMap.put(tempInt, numMap.getOrDefault(tempInt, 0) + 1);
            numList.add(tempInt);
        }

        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], numMap.get(nums[i]) - 1);
            numList.set(i, Integer.MIN_VALUE);

            if (numMap.containsKey(target - nums[i]) && numMap.get(target - nums[i]) > 0) {
                index[0] = i;
                index[1] = numList.indexOf(target - nums[i]);
                break;
            }
            numList.set(i, nums[i]);
            numMap.put(nums[i], numMap.get(nums[i]) + 1);
        }

        return index;
    }

}
