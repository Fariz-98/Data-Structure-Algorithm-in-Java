package study.java.datastructure.algo.leetcode.leetcode50;

// 11
// Medium

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] container = {1,8,6,2,5,4,8,3,7};

        System.out.println(maxArea(container));
    }

    // Optimal-ish solution, but for some runtime, it still goes to 4ms(3ms is the average optimal solution)
    public static int maxArea(int[] height) {
        int leftPointer = 0;
        int rightPointer = height.length - 1;
        int area = 0;

        while (leftPointer < rightPointer) {
            area = Math.max((Math.min(height[leftPointer], height[rightPointer]) * (rightPointer - leftPointer)), area);

            if (height[leftPointer] < height[rightPointer]) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }

        return area;
    }

    // This solution is also not quite as fast as it's supposed to, so finally, I removed the leftptr value and rightptr val
    // and just do every iteration normally, which turns out to be the optimal-ish solution.
    public static int maxAreaThirdSolution(int[] height) {
        int leftPointer = 0;
        int rightPointer = height.length - 1;
        int area = 0;
        int leftMaxVal = 0;
        int rightMaxVal = 0;

        while (leftPointer < rightPointer) {
            if (leftMaxVal > height[leftPointer]) {
                leftPointer++;
                continue;
            } else if (rightMaxVal > height[rightPointer]) {
                rightPointer--;
                continue;
            }

            area = Math.max((Math.min(height[leftPointer], height[rightPointer]) * (rightPointer - leftPointer)), area);

            if (height[leftPointer] < height[rightPointer]) {
                leftMaxVal = height[leftPointer];
                leftPointer++;
            } else {
                rightMaxVal = height[rightPointer];
                rightPointer--;
            }
        }

        return area;
    }

    // This is my second solution, storing the max leftptr and rightptr value. Turns out, this also takes a lot of time
    // to complete. So I removed the space, current area, etc and do the calculation on the spot.
    public static int maxAreaSecondAnswer(int[] height) {
        int leftPointer = 0;
        int rightPointer = height.length - 1;
        int space = height.length - 1;
        int area = 0;
        int currentArea = 0;
        int leftMaxVal = 0;
        int rightMaxVal = 0;

        while (leftPointer < rightPointer) {
            if (leftMaxVal > height[leftPointer]) {
                leftPointer++;
                continue;
            } else if (rightMaxVal > height[rightPointer]) {
                rightPointer--;
                continue;
            }

            currentArea = (Math.min(height[leftPointer], height[rightPointer]) * space);
            area = Math.max(currentArea, area);

            if (height[leftPointer] < height[rightPointer]) {
                leftPointer++;
            } else {
                rightPointer--;
            }
            space--;
        }

        return area;
    }

    // This has a quite big time penalty for some reason, so my first thought was to store left and right max value
    // If the current left pointer or right pointer value is lower than the max, skip the iteration.
    public static int maxAreaInitialAnswer(int[] height) {
        // Two pointer
        // Left and right
        // Space = height.length - 1
        // Move low pointer down/up depending on which is lower, if the same, move either.
        // With each pointer moved, space--, calculate area of the current using Math.low(lowPointer, highPointer) * space.
        // Compare the result with prev using Math.max(currResult, maxWater)

        int leftPointer = 0;
        int rightPointer = height.length - 1;
        int space = height.length - 1;
        int area = 0;
        int currentArea = 0;

        while (leftPointer < rightPointer) {
            currentArea = (Math.min(height[leftPointer], height[rightPointer]) * space);
            area = Math.max(currentArea, area);

            if (height[leftPointer] < height[rightPointer]) {
                leftPointer++;
            } else {
                rightPointer--;
            }
            space--;
        }

        return area;
    }

}
