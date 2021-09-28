package study.java.datastructure.algo;

public class ArrayStructureMain {

    private int[] theArray = new int[50];

    private int arraySize = 10;

    public void generateStaticArray() {

        theArray[0] = 18;
        theArray[1] = 11;
        theArray[2] = 10;
        theArray[3] = 15;
        theArray[4] = 14;
        theArray[5] = 14;
        theArray[6] = 15;
        theArray[7] = 18;
        theArray[8] = 11;
        theArray[9] = 12;
    }

    public void printArray() {

        for (int i = 0; i < arraySize; i++) {
            System.out.println(theArray[i]);
        }
    }

    public String getValueAtIndex(int index) {

        if (index < arraySize) {
            return "The value at index: " + index + " is " + theArray[index];
        } else {
            return "Index out of bounds";
        }
    }

    public boolean doesArrayContainThisValue(int value) {

        boolean contains = false;

        for (int i = 0; i < arraySize; i++) {
            if (theArray[i] == value) {
                contains = true;
                break;
            }
        }
        return contains;
    }

    public void deleteIndex(int index) {

        if (index < arraySize) {
            for (int i = index; i < (arraySize - 1); i++) {
                theArray[i] = theArray[i + 1];
            }
            arraySize -= 1;
        }
    }

    public void insertValue(int value) {

        theArray[arraySize] = value;
        arraySize++;
    }

    public String linearSearchForValue(int value) {

        String where = "The value: " + value + " is located at index: ";

        for (int i = 0; i < arraySize; i++) {
            if (theArray[i] == value) {
                where += i + " ";
            }
        }

        return where;
    }

    public static void main(String[] args) {

        ArrayStructureMain theArray = new ArrayStructureMain();

        theArray.generateStaticArray();

        System.out.println("Current array size: " + theArray.arraySize);
        theArray.printArray();

        System.out.println(theArray.getValueAtIndex(4));

        System.out.println(theArray.doesArrayContainThisValue(18));

        System.out.println("\n");

        theArray.deleteIndex(4);

        System.out.println("Current array size: " + theArray.arraySize);
        theArray.printArray();

        System.out.println("\n");

        theArray.insertValue(30);
        System.out.println("Current array size: " + theArray.arraySize);
        theArray.printArray();

        System.out.println(theArray.linearSearchForValue(15));
    }
}














































