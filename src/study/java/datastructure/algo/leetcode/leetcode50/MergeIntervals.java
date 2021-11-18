package study.java.datastructure.algo.leetcode.leetcode50;

// 56
// Medium

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] input = {
                {1, 3},
                {2,6},
                {8,10},
                {15,18}
        };

        int[][] input2 = {
                {1,4},
                {4,5}
        };

        for (int[] tempIntArr : merge(input2)) {
            System.out.println(Arrays.toString(tempIntArr));
        }
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        // Sort the array
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        // Add a pointer to the start of the array.
        // Add the pointer array to the list
        // If the current pointer array end is more than second array begin, update the current array end value to be either current end or next end
        // Else, change the pointer to the current array, add it to the list
        // Loop continue
        List<int[]> returnList = new ArrayList<>();
        int[] currentPointer = intervals[0];
        returnList.add(currentPointer);

        for (int[] tempInt : intervals) {
            int currentEnd = currentPointer[1];
            int tempBegin = tempInt[0];
            int tempEnd = tempInt[1];

            if (currentEnd >= tempBegin) {
                currentPointer[1] = Math.max(currentEnd, tempEnd);
            } else {
                currentPointer = tempInt;
                returnList.add(currentPointer);
            }
        }

        // Return the list of int to int
        return returnList.toArray(new int[0][2]);
    }

}
































