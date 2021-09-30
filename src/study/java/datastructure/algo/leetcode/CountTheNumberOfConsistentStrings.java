package study.java.datastructure.algo.leetcode;

// 1684
// Easy

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class CountTheNumberOfConsistentStrings {

    public static void main(String[] args) {
        String allowed = "cad";
        String[] words = {"cc","acd","b","ba","bac","bad","ac","d"};
        System.out.println(countConsistentStrings(allowed, words));
    }

    public static int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> allowedSet = new HashSet<>();
        for (int i = 0; i < allowed.length(); i++) {
            allowedSet.add(allowed.charAt(i));
        }
        int count = 0;

        int j = 0;
        while (j < words.length) {
            int cons = 0;
            for (int k = 0; k < words[j].length(); k++) {
                if (allowedSet.contains(words[j].charAt(k))) {
                    cons++;
                }
                if (cons == words[j].length()) {
                    count++;
                }
            }
            j++;
        }
        return count;
    }

}
