package study.java.datastructure.algo.leetcode;

// 1380
// Easy

import java.util.ArrayList;
import java.util.List;

public class LuckyNumbersInAMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,10,4,2},
                {9,3,8,7},
                {15,16,17,12}
        };

        for (int tempInt : luckyNumbers(matrix))
            System.out.println(tempInt);
    }

    public static List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> minInRow = new ArrayList<>();
        List<Integer> maxInColumns = new ArrayList<>();

        // Find the minimum in each row
        for (int i = 0; i < matrix.length; i++) {
            int min = matrix[i][0];
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] <= min)
                    min = matrix[i][j];
            }
            minInRow.add(min);
        }

        // Find the maximum in each column
        int columnSize = matrix.length;
        int rowSize = matrix[0].length;

        for (int i = 0; i < rowSize; i++) {
            int max = 0;
            for (int j = 0; j < columnSize; j++) {
                if (matrix[j][i] >= max)
                    max = matrix[j][i];
            }
            maxInColumns.add(max);
        }

        List<Integer> returnedList = new ArrayList<>();

        for (Integer tempInt : minInRow)
            if (maxInColumns.contains(tempInt))
                returnedList.add(tempInt);

            return returnedList;
    }

}
