package study.java.datastructure.algo.leetcode;

// 1539
// Easy

public class KthMissingPositiveNumber {

    public static void main(String[] args) {
        int[] test1 = {2,3,4,7,11};
        System.out.println(findKthPositiveOptimized(test1, 10));
    }

    public static int findKthPositiveOptimized(int[] arr, int k) {
        int count = 0;
        int number = 1;
        int arrIndex = 0;
        while (true) {
            if (arrIndex < arr.length && arr[arrIndex] != number) {
                count++;
            } else if (arrIndex == arr.length) {
                count++;
            } else {
                arrIndex++;
            }

            if (count == k) {
                return number;
            }

            number++;
        }
    }

    public static int findKthPositive(int[] arr, int k) {
        int count = 0;
        int number = 0;

        // Check for 1
        if (arr[0] != 1) {
            while (arr[0] - number != 1) {
                count++;
                number++;
                if (count == k) {
                    return number;
                }
            }
        }

        // Check for the rest
        for (int i = 0; i < arr.length; i++) {
            if (i + 1 < arr.length && arr[i + 1] - arr[i] != 1) {
                number = arr[i];
                while (arr[i + 1] - number != 1) {
                    count++;
                    number++;
                    if (count == k) {
                        return number;
                    }
                }
            }
        }

        number = arr[arr.length - 1];

        // Check for the end
        while (true) {
            count++;
            number++;
            if (count == k) {
                return number;
            }
        }
    }

}
