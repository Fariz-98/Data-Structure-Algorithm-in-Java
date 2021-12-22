package study.java.datastructure.algo.leetcode.leetcode50;

// 435
// Medium

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

    public static void main(String[] args) {
        int[][] intervalOne = {
                {1,2},
                {2,3},
                {3,4},
                {1,3}
        };

        int[][] intervalTwo = {
                {1,2},
                {1,2},
                {1,2}
        };

        int[][] intervalThree = {
                {1,2},
                {2,3}
        };

        int[][] intervalFour = {
                {1, 100},
                {11,22},
                {1,11},
                {2,12}
        };

        int[][] intervalFive = {
                {0,2},
                {1,3},
                {2,4},
                {3,5},
                {4,6}
        };

        int[][] intervalSix = {
                {-52,31},
                {-72,-26},
                {82,96},
                {-65,-11},
                {-62,-49},
                {95,99},
                {58,95},
                {-31,49},
                {66,98},
                {-63,2},
                {30,47},
                {-40,-26}
        };

        System.out.println(eraseOverlapIntervals(intervalSix));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        // Sort the array
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        for (int[] tempArr : intervals) {
            for (int tempInt : tempArr) {
                System.out.print(tempInt + ",");
            }
            System.out.println();
        }

        // Check each array in intervals
        // if prevStart == currStart, remove the one with higher end val.
        // if currStart < prevEnd, remove the one with higher end val.
        // Else, move prevStart and prevEnd to current.
        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];
        int res = 0;
        for (int i = 1; i < intervals.length; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            if (currStart == prevStart) {
                prevEnd = Math.min(currEnd, prevEnd);
                res++;
            } else if (currStart < prevEnd) {
                prevEnd = Math.min(currEnd, prevEnd);
                if (prevEnd == currEnd)
                    prevStart = currStart;
                res++;
            } else {
                prevStart = currStart;
                prevEnd = currEnd;
            }
        }

        return res;
    }

}
