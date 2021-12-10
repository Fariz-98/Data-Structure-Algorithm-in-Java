package study.java.datastructure.algo.leetcode.leetcode50;

public class PalindromicSubstrings {

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(countSubstrings(s));
    }

    public static int countSubstrings(String s) {
        int palCount = 0;

        for (int i = 0; i < s.length(); i++) {
            palCount += countEvenPalindrome(i, i + 1, s);
            palCount += countOddPalindrome(i, i, s);
        }

        return palCount;
    }

    public static int countEvenPalindrome(int i, int j, String s) {
        int palCount = 0;

        while (i >= 0 && j < s.length()) {
            char leftChar = s.charAt(i);
            char rightChar = s.charAt(j);

            if (leftChar != rightChar)
                break;

            palCount++;

            i--;
            j++;
        }

        return palCount;
    }

    public static int countOddPalindrome(int i, int j, String s) {
        int palCount = 0;

        while (i >= 0 && j < s.length()) {
            char leftChar = s.charAt(i);
            char rightChar = s.charAt(j);

            if (leftChar != rightChar)
                break;

            palCount++;

            i--;
            j++;
        }

        return palCount;
    }

}
