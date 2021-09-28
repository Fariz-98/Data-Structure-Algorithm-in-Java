package study.java.datastructure.algo;

import java.util.Arrays;

public class MinHeapMain {

    public int[] items;

    private int capacity = 10;

    private int size = 0;

    public MinHeapMain() {
        items = new int[capacity];
    }

    // Helper methods
    // For example, because the heap array is in tree form, the tree index will start with/
    //                   1(0)

    //         1(1)                   1(2)

    //    1(3)     1(4)         1(5)        1(6)

    // 1(7) 1(8) 1(9) 1(10) 1(11) 1(12) 1(13) 1(14)

    // To find the parentIndex of index 3, subtract 1 from it = 2, divide by 2 = 1
    // To find the parent index of 11, subtract 1 = 10, divide by 2 = 5;
    // To find the parent index of 14, subtract 1 = 13, divide by 2 = 6.5 but java truncates this to 6.
    private int getParentIndex(int childIndex) {
        return ((childIndex - 1) / 2);
    }

    // To find the leftChild of 4, multiply the index of 4 by 2 = 8, add 1 = 9;
    // To find the rightChild of 0, multiply the index by 2 = 0, add 1 = 1;
    private int getLeftChildIndex(int parentIndex) {
        return ((parentIndex * 2) + 1);
    }

    // To find the rightChild of 5, multiply the index by 2 = 10, add 2 = 12;
    // To find the rightChild of 0, multiply the index by 2 = 0, add 2 = 2;
    private int getRightChildIndex(int parentIndex) {
        return ((parentIndex * 2) + 2);
    }

    // If the child index is smaller than size, the child exist. childIndex == size doesn't exist because
    // when adding an element into the heap, size starts at 0 and is used to insert. e.g, items[size] = newElement.
    // And size is incremented everytime. So for example, if we have 15 element currently, the last value added
    // is into index 14. and the size is incremented to 15. So if we want to add a new element, it will be in
    // items[15] = newElement. and size is now 16 so on and so forth. So the last index value of the array will always
    // be 1 less than size.
    private boolean hasLeftChild(int parentIndex) {
        return getLeftChildIndex(parentIndex) < size;
    }

    private boolean hasRightChild(int parentIndex) {
        return getRightChildIndex(parentIndex) < size;
    }

    // As an array starts at 0, if a child's parent index is more or equal to 0, it means there is a value or parent there.
    private boolean hasParent(int childIndex) {
        return getParentIndex(childIndex) >= 0;
    }

    // Ensure that the array does not exceed max capacity
    private void ensureCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    // Helper method to swap values
    private void swap(int firstIndex, int secondIndex) {
        int tempInt = items[firstIndex];
        items[firstIndex] = items[secondIndex];
        items[secondIndex] = tempInt;
    }

    // Return root value
    public int peek() {
        if (size == 0)
            throw new IllegalArgumentException();
        else
            return items[0];
    }

    // Removing a node
    public int remove() {
        if (size == 0)
            throw new IllegalArgumentException();
        // Store the removed item in a temp variable
        // Set the root of the heap to the last item
        // Heapify downwards the heap because the last item in the heap is now at the root which is wrong
        // minHeap requires smallest value for the parent (root) in this case
        int itemRemoved = items[0];
        items[0] = items[--size];
        items[size] = 0; // Added because without it, the last value will still be present, should be null
        heapifyDown();
        return itemRemoved;
    }

    // Inserting a value
    public void insert(int item) {
        // Ensure the array has enough capacity
        // insert item into size index (starts with 0), incrementing everytime an item is inserted
        // As the capacity starts at 10, once the 9th element is inserted, the size is now 10. The next time this method
        // is called, ensureCapacity method will multiply the array size by 2, this will go on.
        // Finally, heapifyup the heap because the element is inserted at the last index, if it has a lower value than
        // its parent, it has to move up.
        ensureCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    // HeapfyUp the heap to ensure if a parent has a value that is lower than them, they will be swapped
    private void heapifyUp() {
        // Starts at the last value (in this case when we insert an element)
        int index = size - 1;
        // If the index still has parent and the parent value is larger than it, continue the loop
        while (hasParent(index) && items[getParentIndex(index)] > items[index]) {
            // Swap the parent value and the current index value
            swap(getParentIndex(index), index);
            // Index is now pointing to the parent and the loop checks again
            index = getParentIndex(index);
        }
    }

    // HeapifyDown in case where the parent has a larger value than its child, in this case during removal
    private void heapifyDown() {
        // Starts at the root
        int index = 0;
        // If the index still has a left child, because if it doesn't have a left child, the right child wont exist,
        // because heap is inserted from left to right
        while (hasLeftChild(index)) {
            // Get the value of the left child
            int smallestValueIndex = getLeftChildIndex(index);
            // If a right child exist and the value of the right child is smaller than left child, set the smallest
            // value to the rightchild
            if (hasRightChild(index) && items[getRightChildIndex(index)] < items[smallestValueIndex]) {
                smallestValueIndex = getRightChildIndex(index);
            }

            // If the index has a lower value than the smallestvalue variable, stop comparing because it is now correct
            if (items[index] < items[smallestValueIndex]) {
                break;
            } else { // Else, swap the index and the smallestvalueindex variable
                swap(index, smallestValueIndex);
            }

            // Once swapped, point the index to the smallestvalue index and the loop checks again.
            index = smallestValueIndex;
        }
    }

    // Sorting the heap, in this case largest to smallest because it is a minHeap
    public void heapSort() {
        for (int i = size - 1; i >= 0; i--) {
            int smallestVal = remove();
            items[i] = smallestVal;
        }
    }

    // Print the array in tree form, but double digit is not working correctly yet
    // TODO: Fix >one digit printing
    public void printArrayInTreeForm(int[] array) {
        int iteration = 1;
        int spaces = 0;

        int row = findAmountInEachRow(array);

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

                if (indexNumberInEachRow >= array.length) {
                    break;
                }

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

    // Used to print array in tree form
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

    // Used to print array in tree form
    private int findAmountInEachRow(int[] array) {
        int arrayLength = array.length;
        int count = 0;
        int total = 0;
        int iteration = 1;
        while (total <= arrayLength) {
            int formula = (int) Math.pow(2, (iteration - 1));
            total = formula;
            count++;
            iteration++;
        }

        return count;
    }

    public static void main(String[] args) {
        MinHeapMain heap = new MinHeapMain();
        heap.insert(10);
        heap.insert(15);
        heap.insert(20);
        heap.insert(17);
        heap.insert(25);
        heap.insert(13);
        heap.insert(21);
        heap.insert(30);
        heap.insert(31);
        heap.insert(40);
        heap.insert(5);
        heap.insert(7);
        heap.insert(2);
        heap.insert(29);
        heap.insert(19);
        heap.insert(39);
        heap.insert(49);
        heap.insert(33);
        heap.insert(32);
        heap.insert(50);


        for (int tempInt: heap.items) {
            System.out.print(tempInt + " ");
        }

        System.out.println();

        heap.printArrayInTreeForm(heap.items);

        System.out.println();

        heap.remove();

        for (int tempInt: heap.items) {
            System.out.print(tempInt + " ");
        }

        System.out.println();

        heap.printArrayInTreeForm(heap.items);

        System.out.println();

        heap.heapSort();

        for (int tempInt: heap.items) {
            System.out.print(tempInt + " ");
        }
    }

}
