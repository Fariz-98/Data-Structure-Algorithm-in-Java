package study.java.datastructure.algo.sourcecode;

import java.util.Arrays;

public class QSCleaned {

    public static void main(String[] args) {

        int[] theArray = new int[10];

        theArray[0] = 18;
        theArray[1] = 11;
        theArray[2] = 10;
        theArray[3] = 15;
        theArray[4] = 14;
        theArray[5] = 17;
        theArray[6] = 15;
        theArray[7] = 19;
        theArray[8] = 11;
        theArray[9] = 12;

        System.out.println("Before sort: ");
        Arrays.stream(theArray).forEach(System.out::println);

        quickSorts(0, theArray.length - 1, theArray);

        System.out.println("After sort: ");
        Arrays.stream(theArray).forEach(System.out::println);
    }

    public static void quickSorts(int left, int right, int[] array) {

//        if (right - left <= 0)
//            return;

        if (right <= left)
            return;

        else {

            int pivot = array[right];

            int pivotLocation = partitionArrays(left, right, pivot, array);

            quickSorts(left, pivotLocation - 1, array);
            quickSorts(pivotLocation + 1, right, array);
        }
    }

    public static int partitionArrays(int left, int right, int pivot, int[] array) {

        int leftPointer = left - 1;
        int rightPointer = right;

        while (true) {

            while (array[++leftPointer] < pivot);

            while (rightPointer > 0 && array[--rightPointer] > pivot);

            if (leftPointer >= rightPointer)
                break;
            else
                swapValues(leftPointer, rightPointer, array);
        }

        swapValues(leftPointer, right, array);

        return leftPointer;
    }

    public static void swapValues(int firstIndex, int secondIndex, int[] array) {

        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

//    public static void quickSort(int[] array, int left, int right) {
//
//        if (right <= left)
//            return;
//        else {
//
//            int pivot = array[right];
//
//            int partitionReturned = partition(array, left, right, pivot); // left = 0, right = arraysize - 1
//
//            quickSort(array, left, partitionReturned - 1);
//            quickSort(array, partitionReturned + 1, right);
//        }
//    }
}
