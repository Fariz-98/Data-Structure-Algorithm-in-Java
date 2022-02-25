package study.java.datastructure.algo.leetcode.todo;

// 1010
// Medium

import java.util.HashMap;
import java.util.Map;

public class PairsOfSongsWithTotalDurationDivisibleBySixty {

    public static void main(String[] args) {
        int[] time1 = {30,20,150,100,40};
        System.out.println(numPairsDivisibleBy60(time1));
    }

    public static int numPairsDivisibleBy60(int[] time) {
        // Two sum, but, my target is if map contains (x + time % 60 == 0)
        Map<Integer, Integer> timeMap = new HashMap<>();
        for (int tempInt : time) {
            timeMap.put(tempInt, timeMap.getOrDefault(tempInt, 0) + 1);
        }

        int res = 0;

        for (int tempInt : time) {
            // target = any number % 60 == 0;
            timeMap.put(tempInt, timeMap.get(tempInt) - 1);

            System.out.println((60 - tempInt % 60) % 60);

            if (timeMap.containsKey((60 - tempInt % 60) % 60)) {
                res++;
            }

            timeMap.put(tempInt, timeMap.get(tempInt) + 1);
        }

        return res;
    }

}
