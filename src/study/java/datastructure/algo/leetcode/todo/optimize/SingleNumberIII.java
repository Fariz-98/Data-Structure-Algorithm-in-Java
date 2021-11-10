package study.java.datastructure.algo.leetcode.todo.optimize;

// 260
// Medium
// TODO: THE OPTIMAL SOLUTION REQUIRES BIT MANIPULATION, THIS IS NOT OPTIMAL.

import java.util.HashMap;

public class SingleNumberIII {

    public static void main(String[] args) {

    }

    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        int[] returnedInt = new int[2];

        for (int tempInt : nums) {
            numMap.put(tempInt, numMap.getOrDefault(tempInt, 0) + 1);
        }

        for (int tempInt : nums) {
            if (numMap.get(tempInt) == 1 && returnedInt[0] != 0)
                returnedInt[1] = tempInt;

            if (numMap.get(tempInt) == 1 && returnedInt[0] == 0)
                returnedInt[0] = tempInt;
        }
        return returnedInt;
    }

}
