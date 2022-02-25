package study.java.datastructure.algo.leetcode.leetcode50;

// 5
// Medium

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        String res = "";

        for (int i = 0; i < s.length(); i++) {
            int longestPal = res.length();

            String evenPal = countPalindrome(i, i + 1, s);
            String oddPal = countPalindrome(i, i, s);

            if (evenPal.length() > longestPal) {
                res = evenPal;
            } else if (oddPal.length() > longestPal) {
                res = oddPal;
            }

        }

        return res;
    }

    public static String countPalindrome(int left, int right, String s) {
        StringBuilder strBuilder = new StringBuilder();

        while (left >= 0 && right < s.length()) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            if (leftChar != rightChar)
                break;

            if (left == right) {
                strBuilder.append(leftChar);
                left--;
                right++;
                continue;
            }

            String middleChar = strBuilder.toString();
            strBuilder.setLength(0);
            strBuilder.append(leftChar);
            strBuilder.append(middleChar);
            strBuilder.append(rightChar);
            left--;
            right++;
        }

        return strBuilder.toString();
    }

}
