package study.java.datastructure.algo.leetcode.leetcode50;

// 57
// Medium

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    public static void main(String[] args) {

    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            // If newIntervalEnd is less than currentIntervalStart, add it to list along with the rest and return
            if (newInterval[1] < intervals[i][0]) {
                res.add(newInterval);
                for (int j = i; j < intervals.length; j++) {
                    res.add(intervals[j]);
                }
                return res.toArray(new int[res.size()][2]);
            } else if (newInterval[0] > intervals[i][1]){
                // Else if newIntervalStart > currentIntervalEnd, add current to list, this means current interval, doesn't
                // overlap yet
                res.add(intervals[i]);
            } else {
                // Else, update newIntervals because it's overlapping
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            }
        }

        // If the loop exits, that means new interval overlaps until the end of intervals, add to res
        res.add(newInterval);
        return res.toArray(new int[res.size()][2]);
    }

}
