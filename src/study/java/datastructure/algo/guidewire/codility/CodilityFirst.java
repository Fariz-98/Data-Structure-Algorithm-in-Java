package study.java.datastructure.algo.guidewire.codility;

public class CodilityFirst {

    public static void main(String[] args) {
        int[] test = {2, 2, 3, 4, 3, 3, 2, 2, 1, 1, 2, 5};
        int[] test2 = {-3,-3};
        int[] test3 = {3, 3, 3, 4, 2, 2, 2, 1, 2, 2, 2};
        int[] test4 = {3,3,3,3,3,1,1,1,1,1,1};
        int[] test5 = {3,1,0,3};
        int[] test6 = {3,3,3};
        System.out.println(solution(test5));
    }

    public static int solution(int[] A) {
        // If length = 1, only 1 castle can be built
        if (A.length == 1) {
            return 1;
        }

        // If length = 2, if same value, 1 castle can be built, else, 2 castle.
        if (A.length == 2) {
            if (A[0] != A[1]) return 2;
            else return 1;
        }

        // Find first elevation change
        int curr = 0;
        int prev = A[0];
        int firstElevationChange = 0;
        for (int i = 1; i < A.length; i++) {
            curr = A[i];
            if (curr != prev) {
                firstElevationChange = i;
                break;
            }

            // If the hills are the same elevation, return 1
            if (i == A.length - 1) {
                return 1;
            }
        }

        /*
         * Valley and Hill check
         * Valley A[Window] < A[Window - 1] && A[Window] < A[Window + 1]
         * Hills A[Window] > A[Window - 1] && A[Window] > A[Window + 1]
         */

        // Start at 2 because the first and last index window are always valleys or hills
        int castle = 2;

        int start = firstElevationChange;
        int end = firstElevationChange;
        for (int i = firstElevationChange + 1; i < A.length; i++) {
            // If current number is not the same as end of window, check if window is a valley or a hill
            if (A[i] != A[end]) {
                // Check for bounds
                if (start - 1 >= 0 && end + 1 < A.length) {
                    if (A[start] < A[start - 1] && A[end] < A[end + 1]) { // Valley
                        castle++;
                    } else if (A[start] > A[start - 1] && A[end] > A[end + 1]) { // Hill
                        castle++;
                    }
                    // After checking for valley and hill, move both window forward
                    start = end + 1;
                    end = end + 1;
                }
            } else {
                // Else move end window forward
                end = i;
            }
        }

        return castle;
    }

}
