package study.java.datastructure.algo.leetcode;

// 217
// Easy

import java.util.HashMap;

public class ContainsDuplicate {

    public static void main(String[] args) {

    }

    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> numMap = new HashMap<>();

        for (int tempInt : nums) {
            numMap.put(tempInt, numMap.getOrDefault(tempInt, 0) + 1);
            if (numMap.get(tempInt) > 1)
                return true;
        }

        return false;
    }

    // Should SLIGHTLY be faster
    public boolean containsDuplicateSecondSolution(int[] nums) {
        HashMap<Integer, Integer> numMap = new HashMap<>();

        for (int tempInt : nums) {
            if (numMap.containsKey(tempInt))
                return true;
            numMap.put(tempInt, numMap.getOrDefault(tempInt, 0) + 1);
        }

        return false;
    }

}
