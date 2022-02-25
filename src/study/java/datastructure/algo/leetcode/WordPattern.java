package study.java.datastructure.algo.leetcode;

// 290
// Easy

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public static void main(String[] args) {
        wordPattern("aaa", "aa aa aa aa");
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] sSplit = s.split(" ");

        if (pattern.length() != sSplit.length) {
            return false;
        }

        Map<Character, String> patternMap = new HashMap<>();

        for (int i = 0; i < sSplit.length; i++) {
            if (patternMap.containsKey(pattern.charAt(i))) {
                // If the mapped word is the same, continue, else, return false;
                if (!patternMap.get(pattern.charAt(i)).equals(sSplit[i])) {
                    return false;
                }
            } else {
                // If map contains value of the string but does not have the current char, return false
                if (patternMap.containsValue(sSplit[i])) {
                    return false;
                }

                patternMap.put(pattern.charAt(i), sSplit[i]);
            }
        }

        return true;
    }

}
