package study.java.datastructure.algo.leetcode.accepted;

// 349
// Easy

import java.util.*;

public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        int[] nums = {4,9,5};
        int[] nums2 = {9,4,9,8,4};

        for (int tempInt : intersection(nums, nums2))
            System.out.println(tempInt);
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> firstNumSet = buildSortedSet(nums1);
        HashSet<Integer> secondNumSet = buildSortedSet(nums2);

        List<Integer> commonVal = new ArrayList<>();

        for (Integer firstSetVal : firstNumSet) {
            if (secondNumSet.contains(firstSetVal))
                commonVal.add(firstSetVal);
        }

        int[] returnArr = new int[commonVal.size()];

        for (int i = 0; i < returnArr.length; i++)
            returnArr[i] = commonVal.get(i);

        return returnArr;
    }

    public static HashSet<Integer> buildSortedSet(int[] nums) {
        List<Integer> listToSort = new ArrayList<>();

        for (Integer tempInt : nums)
            listToSort.add(tempInt);

        return new HashSet<>(listToSort);
    }

}
