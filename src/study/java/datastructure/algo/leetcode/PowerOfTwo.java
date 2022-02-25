package study.java.datastructure.algo.leetcode;

// 231
// Easy

public class PowerOfTwo {

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1073741825));
    }

    public static boolean isPowerOfTwo(int n) {
        if (n == 1) {
            return true;
        }

        return isPower((double) n);
    }

    public static boolean isPower(Double target) {
        if (target < 2) {
            return false;
        } else if (target == 2) {
            return true;
        }

        target /= 2;

        return isPower(target);
    }

}
