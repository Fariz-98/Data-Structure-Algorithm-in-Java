package study.java.datastructure.algo.leetcode;

// 1502
// Easy

import java.util.Arrays;

public class CanMakeArithmeticProgessionFromSequence {

    public static void main(String[] args) {

    }

    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length == 2) {
            return true;
        }

        Arrays.sort(arr);

        int prevDifference = arr[arr.length - 1] - arr[arr.length - 2];
        for (int i = arr.length - 3; i >= 0; i--) {
            int currDifference = arr[i + 1] - arr[i];

            if (prevDifference != currDifference) {
                return false;
            }
        }

        return true;
    }

}
