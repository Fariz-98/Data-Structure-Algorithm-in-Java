package study.java.datastructure.algo;

public class FizzBuzz {

    public static void main(String[] args) {

        int[] intArray = new int[100];

        int j = 1;

        for (int i = 0; i < 100; i++) {
            intArray[i] = j;
            j++;
        }

        printFizzBuzz(intArray);
    }

    private static void printFizzBuzz(int[] array) {

        for (int i = 0; i < 100; i++) {
            if (array[i] % 3 == 0 && array[i] % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (array[i] % 5 == 0) {
                System.out.println("Buzz");
            } else if (array[i] % 3 == 0) {
                System.out.println("Fizz");
            } else {
                System.out.println(array[i]);
            }
        }
    }
}
