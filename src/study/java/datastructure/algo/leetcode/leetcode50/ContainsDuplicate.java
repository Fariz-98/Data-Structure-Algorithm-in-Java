package study.java.datastructure.algo.leetcode.leetcode50;

// 217
// Easy

import java.util.*;

public class ContainsDuplicate {

    public static void main(String[] args) {

    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        for (Integer tempInt : nums) {
            if (!numSet.add(tempInt)) {
                return true;
            }
        }

        return false;
    }

}
