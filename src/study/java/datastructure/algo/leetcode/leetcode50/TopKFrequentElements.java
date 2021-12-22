package study.java.datastructure.algo.leetcode.leetcode50;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        for (int tempInt : topKFrequent(nums, 2)) {
            System.out.println(tempInt);
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Integer[]> q = new PriorityQueue<>(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if (o1[0] > o2[0]) {
                    return -1;
                } else if (o1[0] < o2[0]) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        Map<Integer, Integer> mapCounter = new HashMap<>();

        for (int tempInt : nums) {
            mapCounter.put(tempInt, mapCounter.getOrDefault(tempInt, 0) + 1);
        }

        for (int tempInt : mapCounter.keySet()) {
            int curr = mapCounter.get(tempInt);
            Integer[] currArr = new Integer[2];
            currArr[0] = curr;
            currArr[1] = tempInt;

            q.add(currArr);
        }

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            Integer[] currArr = q.remove();
            res[i] = currArr[1];
        }

        return res;
    }

}
