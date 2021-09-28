package study.java.datastructure.algo;

public class SortAlgorithmMain {

    public static void main(String[] args) {

        int[] array = ArrayTool.generateStaticArray();

        ArrayTool.printArray(array);

//        SortAlgorithm.bubbleSort(array);
//
//        SortAlgorithm.binarySearchForValues(array, 11);
//
//        SortAlgorithm.selectionSort(array);
//
//        SortAlgorithm.insertionSort(array);
//
        SortAlgorithm.quickSort(array, 0, array.length - 1);
        ArrayTool.printArray(array);
    }


}

class SortAlgorithm {

    //
    //  Tutorial link: https://www.youtube.com/watch?v=JUOyKSZScW0&list=PLGLfVvz_LVvReUrWr94U-ZMgjYTQ538nT&index=2
    //  For: bubbleSort, selectionSort, insertionSort, binarySearchForValues
    //
    //  https://www.youtube.com/watch?v=IlRyO9dXsYE&list=PLGLfVvz_LVvReUrWr94U-ZMgjYTQ538nT&index=8
    //  For: shellSort

    public static void bubbleSort(int[] array) {

        for (int i = array.length - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {

                if (array[j] > array[j + 1]) {
                    swapValue(array, j, j + 1);
                }
            }
        }
    }

    public static void selectionSort(int[] array) {

        for (int i = 0; i < array.length; i++) {

            int minimum = array[i];
            int minIndex = i;

            for (int j = i; j < array.length; j++) {

                if (array[j] < minimum) {

                    minimum = array[j];
                    minIndex = j;
                }
            }

            swapValue(array, i, minIndex);
        }
    }

    public static void insertionSort(int[] array) {

        for (int i = 1; i < array.length; i++) {

            int currentVal = array[i];

            int j = i;

            // This loop checks each element in the sorted array whether the currentVal is lower than them.
            // If it is lower, then the first element in the sorted array is replaced with the current j value.
            // If it is not lower, then the loop stops and the current j value is replaced with currentVal.
            while (j > 0 && array[j - 1] > currentVal) {

                array[j] = array[j - 1];
                j--;
            }

            array[j] = currentVal;
        }
    }

    public static void shellSort(int[] array) {

        int inner;
        int outer;
        int temp;

        // 1. Find the gap for knuth sequence
        int interval = 1;
        for (int i = 1; i < array.length; i = i * 3 + 1)
            interval = i;

        // 2. Create the initial loop that stops when the array is sorted
        // In this case if interval is less than 1, that means the array is sorted
        // In the end, the interval will be decremented using the knuth formula interval = (interval - 1) / 3
        // At the end, the interval final value will be 1 before this loop is stopped
        while (interval > 0) {

            // 3. Create a loop that increment 1 to check for each inner and outer index
            // Outer will start at the same index as interval
            // The condition will be if outer > array size, the loop will stop and the interval will be decremented
            for (outer = interval; outer < array.length; outer++) {

                // The inner loop will also be the same as outer but in another loop, it will be decreased
                // By the interval value
                inner = outer;

                // The temp number will be at the current outer index
                temp = array[outer];

                // 4. Another loop will be created that swaps number in the array if the number at outer (temp)
                // is bigger than inner. If it is not bigger, the loop will not proceed and the loop at 3 will
                // proceed. The loop will also check if inner is more than 0. If it is less than 1, that means inner
                // has gone out of bounds and sorting is done for that particular loop.
                // Once the interval is 1, this loop essentially becomes an insertion sort loop.
                while (inner > 0 && array[inner - interval] > temp) {

                    // Move number from inner index to outer index if it is bigger than the number at outer
                    array[inner] = array[inner - interval];
                    inner -= interval; // Decrement inner with the interval
                }

                // Once the loop is done, replace the array at the current index with temp.
                array[inner] = temp;
            }

            interval = (interval - 1) / 3;
        }
    }

    // 2 Methods belong to quickSort
    public static void quickSort(int[] array, int left, int right) {

        if (right <= left)
            return;
        else {

            int pivot = array[right];

            int sortedIndex = partitionArr(array, left, right, pivot);

            quickSort(array, left, sortedIndex - 1);
            quickSort(array, sortedIndex + 1, right);
        }
    }
    public static int partition(int[] arrayP, int left, int right, int pivot) {

        int leftPointer = left - 1;
        int rightPointer = right;

        while (true) {

            while (arrayP[++leftPointer] < pivot);

            while (rightPointer > 0 && arrayP[--rightPointer] > pivot);

            if (leftPointer >= rightPointer)
                break;
            else
                swapValue(arrayP, leftPointer, rightPointer);
        }

        swapValue(arrayP, leftPointer, right);
        return leftPointer;
    }

    public static int partitionArr(int[] array, int left, int right, int pivot) {

        int pivotIndex = right;
        left--;

        while (left <= right) {

            do {
                left++;
            } while (array[left] < pivot);

            do {
                right--;
            } while (right > 0 && array[right] > pivot);

            if (right <= left)
                break;
            else
            swapValue(array, left, right);
        }

        swapValue(array, left, pivotIndex);
        return left;
    }

    //--------------------------------------------------------------------

    public static void binarySearchForValues(int[] array, int value) {

        int highIndex = array.length - 1;
        int lowIndex = 0;

        while (lowIndex <= highIndex) {

            int middleIndex = (highIndex + lowIndex) / 2;

            if (array[middleIndex] > value) {
                highIndex = middleIndex - 1;
            } else if (array[middleIndex] < value) {
                lowIndex = middleIndex + 1;
            } else {
                System.out.println("The value is found at index: " + middleIndex);
                break;
            }
        }
    }

    public static void swapValue(int[] array, int firstIndex, int secondIndex) {

        int tempInt = array[firstIndex];

        array[firstIndex] = array[secondIndex];
        array[secondIndex] = tempInt;
    }
}

class ArrayTool {

    // TODO: Generate array of the specified size at random
    int[] array;

    public ArrayTool(int arraySize) {

        this.array = new int[arraySize];
    }

    public static int[] generateStaticArray() {

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

        return theArray;
    }

    public static void printArray(int[] array) {

        System.out.println("Current array size: " + array.length);

        for (int tempInt: array)
            System.out.println(tempInt);
    }
}
