package study.java.datastructure.algo.leetcode.leetcode50;

// 3
// Medium

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {

    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        int maxLength = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        Map<Character, Integer> charMap = new HashMap<>();

        while (end < s.length()) {
            charMap.put(s.charAt(end), charMap.getOrDefault(s.charAt(end), 0) + 1);

            if (Collections.max(charMap.values()) > 1) {
                charMap.put(s.charAt(start), charMap.get(s.charAt(start)) - 1);
                start++;
                end++;
            } else {
                maxLength = Math.max(maxLength, (end - start + 1));
                end++;
            }
        }

        return maxLength;
    }

}
// Start with one character, put it in the map, if there is any repeating character afterwards, remove the start,
// Increment start and end.
