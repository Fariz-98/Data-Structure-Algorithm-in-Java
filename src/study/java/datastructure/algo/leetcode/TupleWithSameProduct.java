package study.java.datastructure.algo.leetcode;

// 1726
// Medium

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TupleWithSameProduct {

    public static void main(String[] args) {
        int[] nums = {2,3,4,6};
        int[] nums1 = {1,2,4,5,10};
        int[] nums2 = {2,3,4,6,8,12};
        System.out.println(tupleSameProduct(nums2));
    }

    public static int tupleSameProduct(int[] nums) {
        int res = 0;
        // Multiplied val -> added count (add this to res)
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int curr = nums[i];
                curr *= nums[j];

                // If map have the product, we need to add it by itself (Count previous value)
                if (map.containsKey(curr)) {
                    map.put(curr, map.getOrDefault(curr, 0) + 1);
                    res += map.get(curr);
                } else {
                    map.put(curr, map.getOrDefault(curr, 0));
                }
            }

        }

        return res * 8;
    }

}
