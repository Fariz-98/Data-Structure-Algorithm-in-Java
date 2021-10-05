package study.java.datastructure.algo.leetcode;

// 941
// Easy

public class ValidMountainArray {

    public static void main(String[] args) {
        int[] arr = {0,3,2,1};
        System.out.println(validMountainArray(arr));
    }

    public static boolean validMountainArray(int[] arr) {
        // Check if there is only 1 value in the array
        if (arr.length == 1) {
            return false;
        }

        int largestIndex = 0;
        for (int largestLoop = 0; largestLoop < arr.length; largestLoop++) {
            if (arr[largestLoop] > arr[largestIndex])
                largestIndex = largestLoop;
        }

        // Check for whether the last value is the largest index
        if (arr.length - 1 == largestIndex)
            return false;

        for (int i = 0; i < arr.length; i++) {
            // Check for whether the arr starts with a low value
            if (i == 0 && arr[i + 1] < arr[i])
                return false;

            // Check for increasing value (Left of mountain)
            if (i < largestIndex) {
                if (!(arr[i + 1] > arr[i]))
                    return false;
            }

            // Check for decreasing value (Right of mountain)
            if (i >= largestIndex) {
                if (i == arr.length - 1) {
                    return true;
                }
                if (!(arr[i + 1] < arr[i]))
                    return false;
            }
        }

        return true;
    }

}
