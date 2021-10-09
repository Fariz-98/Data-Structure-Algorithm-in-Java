package study.java.datastructure.algo.leetcode;

// 1365
// Easy

import java.util.*;

public class HowManyNumbersAreSmallerThanTheCurrentNumber {

    public static void main(String[] args) {
        int[] nums = {7,7,7,7};
        for (int tempInt : smallerNumbersThanCurrent(nums)) {
            System.out.println(tempInt);
        }
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        for (Integer tempInt : nums) {
            numMap.put(tempInt, numMap.getOrDefault(tempInt, 0) + 1);
        }

        List<Integer> returnList = new ArrayList<>();
        int smallerNumberCounter = 0;


        for (int i = 0; i < nums.length; i++) {
            smallerNumberCounter = 0;
            for (int j = 0; j < nums[i]; j++) {
                if (numMap.containsKey(j)) {
                   smallerNumberCounter += numMap.get(j);
                }
            }
            returnList.add(smallerNumberCounter);
        }

        int[] returnArr = new int[returnList.size()];
        for (int i = 0; i < returnArr.length; i++) {
            returnArr[i] = returnList.get(i);
        }

        return returnArr;
    }

}
