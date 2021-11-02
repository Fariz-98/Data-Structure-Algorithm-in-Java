package study.java.datastructure.algo.leetcode.todo.notaccepted;

import java.util.Objects;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strArr = {"aac", "a", "ccc"};
        String[] strArr1 = {"flower","flow","flight"};
        String[] strArr2 = {"a", "a", "a"};
        String[] strArr3 = {"ab", "a"};
        String[] strArr4 = {"flower", "flower", "flower", "flower"};
        System.out.println(longestCommonPrefix(strArr4));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (Objects.equals(strs[0], "")) {
            return "";
        }

        String firstWord = strs[0];

        int indexOfPrefix = 1;
        firstLoop:
        for (int i = 0; i < firstWord.length(); i++) {
            for (int j = 0; j < strs.length; j++) {
                if (i == strs[j].length()) {
                    indexOfPrefix = i;
                    break firstLoop;
                }

                if (firstWord.charAt(i) != strs[j].charAt(i)) {
                    indexOfPrefix = i;
                    break firstLoop;
                }
                indexOfPrefix = i;
            }
        }

        return firstWord.substring(0, indexOfPrefix);
    }

}
