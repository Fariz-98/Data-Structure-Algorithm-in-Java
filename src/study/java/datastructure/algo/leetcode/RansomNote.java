package study.java.datastructure.algo.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

public class RansomNote {

    public static void main(String[] args) {
        String ransomNote = "aaaabbbbcccc";
        String magazine = "aaaaabbbbbccccc";

        System.out.println(canConstruct(ransomNote, magazine));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> ransomMap = buildMap(ransomNote);
        HashMap<Character, Integer> magazineMap = buildMap(magazine);

        HashSet<Character> ransomSet = new HashSet<>();

        for (Character tempChar : ransomNote.toCharArray())
            ransomSet.add(tempChar);

        for (Character charToCompare : ransomSet) {
            if (magazineMap.containsKey(charToCompare)) {
                if (ransomMap.get(charToCompare) > magazineMap.get(charToCompare)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static HashMap<Character, Integer> buildMap(String str) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (Character tempChar: str.toCharArray())
            map.put(tempChar, map.getOrDefault(tempChar, 0) + 1);

        return map;
    }
}
