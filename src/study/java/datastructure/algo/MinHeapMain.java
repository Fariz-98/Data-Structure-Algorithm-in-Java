package study.java.datastructure.algo;

import java.util.Arrays;

public class MinHeapMain {

    public int[] items;

    private int capacity = 10;

    private int size = 0;

    public MinHeapMain() {
        items = new int[capacity];
    }

    private int getParentIndex(int childIndex) {
        return ((childIndex - 1) / 2);
    }

    private int getLeftChildIndex(int parentIndex) {
        return ((parentIndex * 2) + 1);
    }

    private int getRightChildIndex(int parentIndex) {
        return ((parentIndex * 2) + 2);
    }

    private boolean hasLeftChild(int parentIndex) {
        return getLeftChildIndex(parentIndex) < size;
    }

    private boolean hasRightChild(int parentIndex) {
        return getRightChildIndex(parentIndex) < size;
    }

    private boolean hasParent(int childIndex) {
        return getParentIndex(childIndex) >= 0;
    }

    private void ensureCapacity() {
        if (size == capacity) {
            Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    private void swap(int firstIndex, int secondIndex) {
        int tempInt = items[firstIndex];
        items[firstIndex] = items[secondIndex];
        items[secondIndex] = tempInt;
    }

    public int peek() {
        if (size == 0)
            throw new IllegalArgumentException();
        else
            return items[0];
    }

    public int remove() {
        if (size == 0)
            throw new IllegalArgumentException();
        int itemRemoved = items[0];
        items[0] = items[--size];
        items[size] = 0;
        heapifyDown();
        return itemRemoved;
    }

    public void insert(int item) {
        ensureCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && items[getParentIndex(index)] > items[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallestValueIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && items[getRightChildIndex(index)] < items[smallestValueIndex]) {
                smallestValueIndex = getRightChildIndex(index);
            }

            if (items[index] < items[smallestValueIndex]) {
                break;
            } else {
                swap(index, smallestValueIndex);
            }

            index = smallestValueIndex;
        }
    }

    public void printArrayInTreeForm2(int row, int[] array) {
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

    public static void main(String[] args) {
        MinHeapMain heap = new MinHeapMain();
        heap.insert(10);
        heap.insert(15);
        heap.insert(20);
        heap.insert(17);
        heap.insert(25);

        heap.remove();

        for (int tempInt: heap.items) {
            System.out.print(tempInt + " ");
        }

        System.out.println();

        heap.printArrayInTreeForm2(3, heap.items);
    }

}
