package study.java.datastructure.algo.leetcode;

// 1
// Easy

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {0, 4, 3, 0};

        for (int tempInt : twoSum(nums, 0)) {
            System.out.println();
            System.out.println(tempInt);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        int[] indices = new int[2];
        List<Integer> integerList = new ArrayList<>();

        for (int tempInt : nums) {
            numMap.put(tempInt, numMap.getOrDefault(tempInt, 0) + 1);
            integerList.add(tempInt);
        }

        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], numMap.get(nums[i]) - 1);

            if (numMap.containsKey(target - nums[i]) && numMap.get(target - nums[i]) > 0) {
                indices[0] = i;
                if (target - nums[i] == nums[i]) {
                    int indexOfNums = integerList.indexOf(target - nums[i]);
                    integerList.set(indexOfNums, Integer.MIN_VALUE);
                    indices[1] = integerList.indexOf(target - nums[i]);
                    break;
                }
                indices[1] = integerList.indexOf(target - nums[i]);
                break;
            }
        }
        return indices;
    }

}
