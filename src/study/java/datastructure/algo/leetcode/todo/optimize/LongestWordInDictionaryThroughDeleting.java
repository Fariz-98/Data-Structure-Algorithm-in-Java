package study.java.datastructure.algo.leetcode.todo.optimize;

// 524
// Medium

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LongestWordInDictionaryThroughDeleting {

    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> dict = List.of(
                "ale",
                "apple",
                "monkey",
                "plea"
        );

        String s1 = "abpcplea";
        List<String> dict1 = List.of(
                "a","b","c"
        );

        String s2 = "bab";
        List<String> dict2 = List.of(
                "ba","ab","a","b"
        );

        String s3 = "aewfafwafjlwajflwajflwafj";
        List<String> dict3 = List.of(
                "apple","ewaf","awefawfwaf","awef","awefe","ewafeffewafewf"
        );

        System.out.println(findLongestWord(s1, dict1));
    }

    public static String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        int resLexiLength = 0;

        // Loop over dictionary copying s array each time to count char
        for (int i = 0; i < dictionary.size(); i++) {
            String currStr = dictionary.get(i);
            resLexiLength = res.length();
            int currLexiLength = 0;
            int sIndex = 0;

            for (int j = 0; j < currStr.length(); j++) {
                char currChar = currStr.charAt(j);

                while (s.charAt(sIndex) != currChar) {
                    currLexiLength += currChar - 'a';
                    sIndex++;

                    if (sIndex == s.length()) {
                        currLexiLength = 0;
                        break;
                    }
                }
            }

            if (currLexiLength > 0) {

            }
        }

        return "";
    }

}




























