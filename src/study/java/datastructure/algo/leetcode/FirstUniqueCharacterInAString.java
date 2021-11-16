package study.java.datastructure.algo.leetcode;

// 387
// Easy

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FirstUniqueCharacterInAString {

    public static void main(String[] args) {

    }

    public static int firstUniqChar(String s) {
        Map<Character, Integer> charMap = new HashMap<>();

        for (Character tempChar : s.toCharArray()) {
            charMap.put(tempChar, charMap.getOrDefault(tempChar, 0) + 1);
        }

        char[] charArr = s.toCharArray();

        for (int i = 0; i < charArr.length; i++) {
            if (charMap.get(charArr[i]) == 1) {
                return i;
            }
        }

        return -1;
    }

}
