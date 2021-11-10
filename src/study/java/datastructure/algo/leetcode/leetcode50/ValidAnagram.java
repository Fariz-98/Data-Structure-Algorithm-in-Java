package study.java.datastructure.algo.leetcode.leetcode50;

// 242
// Easy

import java.util.*;

public class ValidAnagram {

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagramMap(s, t));
    }

    // Using sorted list
    public static boolean isAnagramList(String s, String t) {
        if (s.length() != t.length())
            return false;

        return buildList(s).equals(buildList(t));
    }

    public static List<Character> buildList(String s) {
        List<Character> charList = new ArrayList<>();

        for (Character tempChar : s.toCharArray())
            charList.add(tempChar);

        Collections.sort(charList);

        return charList;
    }

    public static boolean isAnagramMap(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        return buildMap(s).equals(buildMap(t));
    }

    public static Map<Character, Integer> buildMap(String s) {
        Map<Character, Integer> sMap = new HashMap<>();

        for (Character tempChar : s.toCharArray()) {
            sMap.put(tempChar, sMap.getOrDefault(tempChar , 0) + 1);
        }

        return sMap;
    }

//    // Using map
//    public static boolean isAnagramMap(String s, String t) {
//        if (s.length() != t.length())
//            return false;
//
//        return buildMap(s).equals(buildMap(t));
//    }
//
//    public static HashMap<Character, Integer> buildMap(String s) {
//        HashMap<Character, Integer> charMap = new HashMap<>();
//
//        for (Character tempChar : s.toCharArray())
//            charMap.put(tempChar, charMap.getOrDefault(tempChar, 0) + 1);
//
//        return charMap;
//    }

}
