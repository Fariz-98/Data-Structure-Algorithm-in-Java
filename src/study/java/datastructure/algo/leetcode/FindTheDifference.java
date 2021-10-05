package study.java.datastructure.algo.leetcode;

// 389
// Easy

import java.util.HashMap;
import java.util.Map;

public class FindTheDifference {

    public static void main(String[] args) {
        String s = "ae";
        String t = "aea";

        System.out.println(findTheDifference(s, t));
    }

    public static char findTheDifference(String s, String t) {
        Map<Character, Integer> firstWordMap = fillHashMap(s);
        Map<Character, Integer> secondWordMap = fillHashMap(t);
        char returnChar = 0;

        for (char tempChar : t.toCharArray()) {
            // Check for whether the second string has another char added
            if (!firstWordMap.containsKey(tempChar)) {
                returnChar = tempChar;
            }

            // Check for whether all character has the same amount in the string
            if (firstWordMap.get(tempChar) != secondWordMap.get(tempChar)) {
                returnChar = tempChar;
            }
        }
        
        return returnChar;
    }

    public static HashMap<Character, Integer> fillHashMap(String s) {
        HashMap<Character, Integer> wordMap = new HashMap<>();

        for (char tempChar: s.toCharArray())
            wordMap.put(tempChar, wordMap.getOrDefault(tempChar, 0) + 1);

        return wordMap;
    }

}
