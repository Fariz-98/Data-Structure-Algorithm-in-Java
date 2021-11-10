package study.java.datastructure.algo.leetcode.accepted;

// 1979
// Easy

public class FindGreatestCommonDivisorOfArray {

    public static void main(String[] args) {

    }

    public int findGCD(int[] nums) {
        int smallest = nums[0];
        int largest = nums[0];

        for (int tempInt : nums) {
            if (tempInt <= smallest)
                smallest = tempInt;
            else if (tempInt >= largest)
                largest = tempInt;
        }

        int gcd = 1;
        for (int i = 1; i <= smallest; i++) {
            if (smallest % i == 0 && largest % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

}
