package study.java.datastructure.algo.leetcode.leetcode50;

// 128
// Medium

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] test1 = {100,4,200,1,3,2};
        int[] test2 = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(test2));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums == null) {
            return 0;
        }

        // Initially 1 because there will always be at least 1 consecutive number
        int res = 1;

        Set<Integer> set = new HashSet<>();
        for (int tempInt : nums) {
            set.add(tempInt);
        }

        for (int tempInt : nums) {
            int current = tempInt;

            if (!set.contains(current - 1)) {
                int currentCount = 1;
                while (set.contains(current + 1)) {
                    currentCount++;
                    current++;
                }
                res = Math.max(res, currentCount);
            }
        }

        return res;
    }

    public static int longestConsecutiveWithHeap(int[] nums) {
        // Not optimal
        PriorityQueue<Integer> q = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();

        for (int tempInt : nums) {
            if (set.add(tempInt)) {
                q.add(tempInt);
            }
        }

        int currentCount = 1;
        int res = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            if (!q.isEmpty() && curr + 1 == q.peek()) {
                currentCount++;
            } else {
                currentCount = 1;
            }

            res = Math.max(res, currentCount);
        }

        return res;
    }

}
