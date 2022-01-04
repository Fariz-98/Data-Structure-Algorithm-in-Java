package study.java.datastructure.algo.leetcode;

// 1957
// Easy

import java.util.HashMap;
import java.util.Map;

public class DeleteCharactersToMakeFancyString {

    public static void main(String[] args) {
        String s1 = "leeetcode";
        System.out.println(makeFancyString(s1));
    }

    public static String makeFancyString(String s) {
        StringBuilder strBuilder = new StringBuilder();

        int currCharCount = 0;
        char prevChar = Character.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);

            if (currChar != prevChar) {
                currCharCount = 0;
                prevChar = currChar;
            } else {
                currCharCount++;
            }

            if (currCharCount < 2) {
                strBuilder.append(currChar);
            }

        }

        return strBuilder.toString();
    }

}
