package study.java.datastructure.algo.leetcode.leetcode50;

// 424
// Medium

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        String a = "ABAB";
        String b = "AABABBA";
        String c = "ABAA";
        String d = "ABABBA";
        String e = "ABCDE";

        System.out.println(characterReplacement(e,1));
    }

    public static int characterReplacement(String s, int k) {
        int maxLength = Integer.MIN_VALUE;
        Map<Character, Integer> charMap = new HashMap<>();
        int start = 0;
        int end = 0;

        while (end < s.length()) {
            charMap.put(s.charAt(end), charMap.getOrDefault(s.charAt(end), 0) + 1);

            if ((end - start + 1) - Collections.max(charMap.values()) <= k) {
                maxLength = end - start + 1;
                end++;
            } else {
                charMap.put(s.charAt(start), charMap.get(s.charAt(start)) - 1);
                start++;
                end++;
            }
        }

        return maxLength;
    }

}

// Solved using sliding window
// Move 2 pointers, store each character in a hashmap of alphabet with the end pointer
// Calculate end - highest char count in the hashmap, if the result is lower than k, then the sliding window is valid
// because we only have to replace the character that is not consecutive, e.g. ABABBA, k = 2, if start is at first A and end
// is at last B, our sliding window length is 5 and we have 3 consecutive char, B, so we substract the B count
// and now we are left with 2 which is equal to our given k 2, so we can replace the A with B. Now we can
// update our Result with Math.max(result, currentLength)
// If it's higher than k, then we will move the start ptr + 1 and find the max length again.
// Then repeat third calculation until end is == s.length