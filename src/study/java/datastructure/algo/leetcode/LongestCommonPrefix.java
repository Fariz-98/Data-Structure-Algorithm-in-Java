package study.java.datastructure.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class  LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strArr = {"aac", "a", "ccc"};
        String[] strArr1 = {"flower","flow","flight"};
        String[] strArr2 = {"a", "a", "a"};
        String[] strArr3 = {"ab", "a"};
        String[] strArr4 = {"flower", "flower", "flower", "flower"};
        String[] strArr5 = {"reflower", "flow", "flight"};
        String[] strArr6 = {"aac", "acab", "aa", "abba", "aa"};
        String[] strArr7 = {"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(strArr7));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        Arrays.sort(strs);
        String firstWord = strs[0];
        String lastWord = strs[strs.length - 1];

        for (String tempString : strs)
            System.out.println(tempString);

        int prefix = 0;

        for (int i = 0; i < firstWord.length(); i++) {
            if (firstWord.charAt(i) == lastWord.charAt(i)) {
                System.out.println("same?");
                prefix++;
            } else {
                break;
            }
        }

        if (prefix != 0) {
            return firstWord.substring(0, prefix);
        } else {
            return "";
        }
    }

}
