package study.java.datastructure.algo.leetcode.leetcode50;

// Hard
// 76

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        String input1 = "ADOBECODEBANC";
        String input2 = "a";
        String input3 = "cabwefgewcwaefgcf";
        System.out.println(minWindow(input3,"cae"));
    }

    public static String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> tMap = new HashMap<>();
        for (Character tempChar: t.toCharArray()) {
            tMap.put(tempChar, tMap.getOrDefault(tempChar, 0) + 1);
        }

        int needCount = 0;
        for (Character tChar: tMap.keySet()) {
            needCount++;
        }

        int start = 0;
        int end = 0;
        int includeCount = 0;
        int currResult = 0;
        int prevResult = Integer.MAX_VALUE;
        Map<Character, Integer> sMap = new HashMap<>();
        String result = "";

        while (end < s.length()) {
            char currChar = s.charAt(end);

            if (tMap.containsKey(currChar)) {
                sMap.put(currChar, sMap.getOrDefault(currChar, 0) + 1);

                // WHY THIS FAILED WTF?????
                // https://leetcode.com/problems/minimum-window-substring/discuss/266059/Why-you-failed-the-last-test-case%3A-An-interesting-bug-when-I-used-two-HashMaps-in-Java
                // NEVER COMPARE JAVA OBJECT TYPE USING ==
//                if (sMap.get(currChar) == tMap.get(currChar)) {
//                    includeCount++;
//                }

                if ((sMap.get(currChar).equals(tMap.get(currChar)))) {
                    includeCount++;
                }

                while (includeCount == needCount) {
                    char startChar = s.charAt(start);
                    currResult = end - start + 1;

                    if (currResult < prevResult) {
                        prevResult = currResult;
                        result = s.substring(start, end + 1);
                    }

                    if (sMap.containsKey(startChar)) {
                        sMap.put(startChar, sMap.get(startChar) - 1);

                        if (sMap.get(startChar) < tMap.get(startChar)) {
                            includeCount--;
                        }
                    }

                    start++;
                }
            }
            end++;
        }

        return result;
    }


}






































