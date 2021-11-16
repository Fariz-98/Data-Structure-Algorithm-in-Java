package study.java.datastructure.algo.leetcode;

// 344
// Easy

public class ReverseString {

    static char[] s;

    public static void main(String[] args) {
        String t = "Hannah";
        s = t.toCharArray();
        reverseString(s);
        for (char tempChar : s)
            System.out.println(tempChar);
    }

    public static void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;

        while (i < s.length) {
            char tempChar = s[i];
            s[i] = s[j];
            s[j] = tempChar;

            i++;
            j--;

            if (i == j || i > j)
                break;
        }
    }

}
