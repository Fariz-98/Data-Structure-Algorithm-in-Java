package study.java.datastructure.algo.ds;

import java.util.ArrayList;
import java.util.Arrays;

public class HashTableMain {

    String[] theArray;
    int arraySize;

    public static void main(String[] args) {

        HashTableMain hashTableMain = new HashTableMain(30);
//        String[] elementsToAdd = {"1", "5", "17", "21", "26"};
        String[] elementsToAdd = {"100", "510", "170", "214", "268", "398",
                                    "235", "802", "900", "723", "699", "1",
                                    "16", "999", "890", "725", "998", "978",
                                    "988", "990", "989", "984", "320", "321",
                                    "400", "415", "450", "50", "660", "624"};

        String[] elementsToAdd2 = { "30", "60", "90", "120", "150", "180",
                "210", "240", "270", "300", "330", "360", "390", "420", "450",
                "480", "510", "540", "570", "600", "989", "984", "320", "321",
                "400", "415", "450", "50", "660", "624" };

        hashTableMain.HashFunc2(elementsToAdd2, hashTableMain.theArray);
        hashTableMain.increaseArraySize(60);
        hashTableMain.displayHashTable(hashTableMain.theArray);
        System.out.println();
        System.out.println();

        hashTableMain.fillArrayWithNegValue();
        hashTableMain.displayHashTable(hashTableMain.theArray);
        System.out.println();
        System.out.println();

        hashTableMain.DoubleHashFunc2(elementsToAdd2, hashTableMain.theArray);
        hashTableMain.displayHashTable(hashTableMain.theArray);
        System.out.println();
        System.out.println();

        hashTableMain.findKeyForDoubleHashFunction2("625", hashTableMain.theArray);
    }

    public HashTableMain(int size) {

        arraySize = size;
        theArray = new String[size];
        Arrays.fill(theArray, "-1");
    }

    public void fillArrayWithNegValue() {
        Arrays.fill(theArray, "-1");
    }

    // This hash function just takes the value of the element to fill in the hash table
    public void HashFunc(String[] elementToFill, String[] theArray) {

        for (int i = 0; i < elementToFill.length; i++) {

            String newElement = elementToFill[i];
            Integer index = Integer.parseInt(newElement);
            theArray[index] = newElement;
        }
    }

    // This hash function gets the mod of the value that you want to put in and that's the index for it
    // If the index has already been filled, it increment the index by 1 and try the next one until it finds
    // an empty spot, in this case -1
    // If the index == arraysize, the index gets reset to 0 again and start over until it finds an empty spot
    // in this case -1
    public void HashFunc2(String[] elementToFill, String[] theArray) {

        for (int i = 0; i < elementToFill.length; i++) {

            String newElement = elementToFill[i];
            int index = Integer.parseInt(newElement) % arraySize;
            System.out.println("Element to fill: " + newElement);

            while (!theArray[index].equals("-1")) {

                System.out.println("Collision occured at index: " + index);
                ++index;
                System.out.println("Try index: " + index + " instead");

                index %= arraySize;
            }

            System.out.println("New element inserted at index: " + index);
            theArray[index] = newElement;
        }
    }

    // In HashFunc2, there will be many collisions and clustering with many empty spaces, in order to avoid that
    // We can double hash the number instead of incrementing by 1 every time a collision occured.
    // This will minimize clustering and the number of collisions in the hashtable

    public void DoubleHashFunc2(String[] elementToFill, String[] theArray) {
        for (int i = 0; i < elementToFill.length; i++) {

            String newElement = elementToFill[i];
            System.out.println("Element to fill: " + newElement);
            int index = Integer.parseInt(newElement) % arraySize;
            int stepDistance = 5 - (Integer.parseInt(newElement) % 5); // Double hashing the new element

            while (!theArray[index].equals("-1")) {
                System.out.println("Collision occured at index: " + index);
                index += stepDistance;
                System.out.println("Try index: " + index + " instead");

                index %= arraySize; // Using %= arraySize, we can go back to 0 without stepDistance
                // If we're using stepDistance, there is a possibility that the index that incremented will go over
                // 60, which means it will not make it back to 0 when we do index %= arraySize
                // In the tutorial, he uses index %= arraySize but in order to start over at 0,
                // if (index >= arraySize) { index = 0 }; can be used.
                // I'm leaving it at index %= though because I want it to be the same as his to compare my code output
                // NOTE: in his code, he commented "// If we get to the end of the array go back to index 0"
                // Indicating that it is used to start over at 0.
            }

            System.out.println("New element inserted at index: " + index);
            theArray[index] = newElement;
        }
    }

    public String findKeyForFunction2(String key, String[] hashTable) {

        Integer index = Integer.parseInt(key) % arraySize;

        String value = hashTable[index];

        // If the hashTable[index] matches the key, returns the value right away
        if (value.equals(key)) {

            System.out.println("Value found at index: " + index);
            return value;
        }
        // Else if the key you're trying to find collided with another element, increment the index
        // until it finds the index where the value equals the key
        else {

            while (index < arraySize && !hashTable[index].equals("-1")) {

                ++index;
//                if (index >= arraySize) {
//                    index = 0;
//                }

                if (hashTable[index].equals(key)) {
                    System.out.println("Value found at index: " + index);
                    return hashTable[index];
                }
            }
            return null;
        }
    }

    public String findKeyForDoubleHashFunction2(String key, String[] hashTable) {
        int index = Integer.parseInt(key) % arraySize;
        int stepDistance = 5 - (Integer.parseInt(key) % 5);
        int amountSearched = 0;

        while (!hashTable[index].equals(key)) {
            index += stepDistance;

            // I'm using amountSearched to track for not available element
            // Since in this loop, if an element is never found, it will go on forever, amountSearched is used
            // where if the loop has searched the hashTable for n number of times and the element is never found,
            // it will return null with a not found value message.
            if (index >= arraySize) {
                if (amountSearched == 3) {
                    System.out.println("Value not found");
                    return null;
                }
                amountSearched++;
                index %= arraySize;
            }
        }

        System.out.println("Value found at index: " + index);
        return hashTable[index];
    }

    // For hashtable, a size of prime number is usually good as in the real world, data follow patterns.
    // For example, using an arraySize of 30, when inputting data such as 30, 60, 90, 120, etc, there will be many
    // collisions. But if we're using an arraySize of 31, less collision will occur when using such data that follow
    // patterns.
    // 1. To increase our hash table size to a prime number size, we need:
    //  a. a way to check for whether the number is a prime number
    //  b. get the next prime number of specified hash table size
    //  c. increase hashtable size method where it takes in the minimum array size
    //  d. a method to migrate old array to new array
    //  e. a method to clean array of empty spaces so that there will be no empty spaces when migrating to a new array
    //     in our case, the empty spaces are "-1".

    // c. increase hash table size, we will call this method from our main
    public void increaseArraySize(int minArraySize) {

        // Get the new array size from our previous getNextPrime method
        int newArraySize = getNextPrime(minArraySize);

        // Migrate our old array to our new increased size array
        migrateArray(newArraySize);
        System.out.println();
        System.out.println("New array size: " + newArraySize);
    }

    // d. move old array method
    public void migrateArray(int newArraySize) {

        // Clean the array so that there are no empty spaces ("-1")
        String[] cleanedArray = cleanArray(theArray);

        // Create a new array of the new specified size
        theArray = new String[newArraySize];

        // Specify the new size
        arraySize = newArraySize;

        // Fill the array with empty spaces ("-1")
        Arrays.fill(theArray, "-1");

        // Use the hashfunction2 again to fill the array with values from our cleaned array and the new array
        HashFunc2(cleanedArray, theArray);
    }

    // a. isPrime method
    public boolean isPrime(int number) {

        if (number == 0 || number == 1)
            return false;

        for (int i = 2; i <= Math.sqrt(number); i++)
            if (number % i == 0)
                return false;

        return true;
    }

    // b. Get the next prime number of a specified number
    public int getNextPrime(int minimumNumber) {

        int i = minimumNumber;

        if (isPrime(i))
            return i;
        else {
            while (true) {
                i++;
                if (isPrime(i))
                    return i;
            }
        }
    }

    // e. A method that removes empty spaces ("-1")
    public String[] cleanArray(String[] arrayToClean) {

        ArrayList<String> list = new ArrayList<>();

        for (String tempString: arrayToClean)
            if (!tempString.equals("-1"))
                list.add(tempString);

        return list.toArray(new String[list.size()]);
    }

    public void displayHashTable(String[] theArray) {

        for (String tempString: theArray) {
            System.out.print(tempString + " ");
        }
    }
}



// +AndyHOTlife
// Sorry about that. This is a shortcut. Modulus gives us the remainder from a division. So what I'm doing here is if
// the index ever equals the arraySize I want to change the index to 0. So, if arraySize and arrayIndex are both equal
// to 15 then I change the value of arrayIndex to 0. 15 % 15 = 0. I hope that cleared it up.

