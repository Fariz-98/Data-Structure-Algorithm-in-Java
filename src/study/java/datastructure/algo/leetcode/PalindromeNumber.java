package study.java.datastructure.algo.leetcode;

// 9
// Easy

public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));
    }

    public static boolean isPalindrome(int x) {
        String number = String.valueOf(x);
        int i = number.length() - 1;
        int j = 0;

        while (j < i) {
            if (number.charAt(i) != number.charAt(j)) {
                return false;
            }

            i--;
            j++;
        }

        return true;
    }

}
