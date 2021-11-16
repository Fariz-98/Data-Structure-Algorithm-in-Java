package study.java.datastructure.algo.leetcode;

// 1768
// Easy

public class MergeStringsAlternately {

    public static void main(String[] args) {
        System.out.println(mergeAlternately("abcd", "pq"));
    }

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder mergedWord = new StringBuilder();

        int i = 0;
        int j = 0;
        while (true) {
            if (i == word1.length() && j == word2.length())
                break;
            if (i < word1.length()) {
                mergedWord.append(word1.charAt(i));
                i++;
            }
            if (j < word2.length()) {
                mergedWord.append(word2.charAt(j));
                j++;
            }
        }

        return mergedWord.toString();
    }

}
