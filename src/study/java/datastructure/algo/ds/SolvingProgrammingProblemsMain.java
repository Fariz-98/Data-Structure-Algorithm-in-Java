package study.java.datastructure.algo.ds;

import java.util.Arrays;

public class SolvingProgrammingProblemsMain {

    public static void main(String[] args) {

        int[] theArray = new int[200];
        generateFilledArray(9, theArray);

        printArrayInTreeForm2(7, theArray);
    }

    public static void generateFilledArray(int randNum, int[] theArray) {
        for (int i = 0; i < theArray.length; i++) {
            theArray[i] = (int) (Math.random() * randNum) + 1;
        }
    }

    private static void printArrayInTreeForm(int row, int[] array) {
        int iteration = 1;
        int spaces = 0;

        while (iteration <= row) {
            int indentation = (int) Math.abs((Math.pow(-2, -iteration)) * ((Math.pow(2, iteration) - 16)));
            int numberInEachRow = (int) (Math.abs(Math.pow(2, iteration - 1)));
            int indexNumberInEachRow = (int) (Math.abs(0.5 * (Math.pow(2, iteration) - 2)));

            for (int i = 0; i < indentation; i++)
                System.out.print(" ");

            int i = 0;

            while (true) {
                if (i == numberInEachRow)
                    break;

                System.out.print(array[indexNumberInEachRow]);

                for (int k = 0; k < spaces; k++)
                    System.out.print(" ");

                i++;
                indexNumberInEachRow++;
            }

            System.out.println();
            spaces = indentation;
            iteration++;
        }
    }

    private static void printArrayInTreeForm2(int row, int[] array) {
        int iteration = 1;
        int spaces = 0;

        Integer[] indentation = generateIndentation(row);

        while (iteration <= row) {

            int numberInEachRow = (int) (Math.abs(Math.pow(2, iteration - 1)));
            int indexNumberInEachRow = (int) (Math.abs(0.5 * (Math.pow(2, iteration) - 2)));

            for (int i = 0; i < indentation[iteration - 1]; i++)
                System.out.print(" ");

            int i = 0;

            while (true) {
                if (i == numberInEachRow)
                    break;

                System.out.print(array[indexNumberInEachRow]);

                for (int k = 0; k < spaces; k++)
                    System.out.print(" ");

                i++;
                indexNumberInEachRow++;
            }

            System.out.println();
            spaces = indentation[iteration - 1];
            iteration++;
        }
    }

    private static Integer[] generateIndentation(int row) {
        if (row == 0) {
            Integer[] i = {0};
        }

        Integer[] indentArray = new Integer[row];

        int j = 1;

        for (int i = 0; i < row; i++) {
            indentArray[i] = (int) (Math.abs(0.5 * (Math.pow(2, j) - 2)));
            j++;
        }

        Arrays.sort(indentArray, (l, m) -> { // Can also use Comparator.reverseOrder
            if (l > m)
                return -1;
            else if (l < m)
                return 1;
            else
                return 0;
        });

        return indentArray;
    }

}
