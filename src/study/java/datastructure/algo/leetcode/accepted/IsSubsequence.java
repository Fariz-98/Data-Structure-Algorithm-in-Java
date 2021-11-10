package study.java.datastructure.algo.leetcode.accepted;

// 392
// Easy

import java.util.ArrayList;
import java.util.List;

public class IsSubsequence {

    public static void main(String[] args) {
        String s = "abcccdeee";
        String t = "aaabbbbffcccdddeeeaaa";

        isSubsequence(s, t);
    }

    public static boolean isSubsequence(String s, String t) {
        List<Character> listOfS = new ArrayList<>();
        StringBuilder cleanedT = new StringBuilder();

        for (Character tempChar : s.toCharArray())
            listOfS.add(tempChar);

        int j = 0;

        for (int i = 0; i < t.length(); i++) {
            if (j < listOfS.size() && t.charAt(i) == listOfS.get(j)) {
                cleanedT.append(t.charAt(i));
                listOfS.remove(j);
            }
        }

        return cleanedT.toString().contains(s);
    }

}
