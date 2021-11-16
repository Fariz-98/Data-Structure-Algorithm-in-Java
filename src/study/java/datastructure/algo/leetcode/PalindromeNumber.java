package study.java.datastructure.algo.leetcode;

// 9
// Easy

public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(isPalindrome(122222221));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        String theNumber = String.valueOf(x);

        int j = theNumber.length() - 1;

        for (int i = 0; i < theNumber.length(); i++) {
            if (theNumber.charAt(i) != theNumber.charAt(j))
                return false;
            j--;
        }

        return true;
    }

}
