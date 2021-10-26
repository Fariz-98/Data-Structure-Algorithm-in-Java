package study.java.datastructure.algo.leetcode.todo;

// 890
// Medium
// TODO: Optimize to run better & faster
// This solution currently maps each character in a word to an integer value. For example, a = 1, b = 2, etc.
// Even if the string starts with a different character, x = 1, z = 2, a = 3, etc.
// The amount of time each character appears is stored in a variable which is then stored in a list.
// So aabbcc will be 11-22-33 in the list.
// Each word in the words array is converted and compared to the converted pattern.
// This solution is very slow and takes a lot of memory.

import java.util.*;

public class FindAndReplacePattern {

    public static void main(String[] args) {
        String[] words = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        String pattern = "abb";

        for (String tempString : findAndReplacePattern(words, pattern))
            System.out.println(tempString);
    }

    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        Integer[] patternNumber = buildPattern(pattern);
        Integer[] wordNumber = null;
        List<String> returnList = new ArrayList<>();

        for (String tempString : words) {
            wordNumber = buildPattern(tempString);

            if (Arrays.equals(patternNumber, wordNumber))
                returnList.add(tempString);
        }

        return returnList;
    }

    public static Integer[] buildPattern(String words) {
        List<Integer> patternNumberList = new ArrayList<>();
        HashMap<Character, Integer> charDictionaryIndex = new HashMap<>();

        int charIndex = 1;
        Character currentChar = null;

        for (int i = 0; i < words.length(); i++) {
            Character wordsCurrentChar = words.charAt(i);

            if (currentChar == null) {
                currentChar = wordsCurrentChar;
                patternNumberList.add(charIndex);
                charDictionaryIndex.put(wordsCurrentChar, charIndex);
                continue;
            }

            if (wordsCurrentChar != currentChar) {
                if (charDictionaryIndex.containsKey(wordsCurrentChar)) {
                    currentChar = wordsCurrentChar;
                    patternNumberList.add(charDictionaryIndex.get(wordsCurrentChar));
                    continue;
                } else {
                    currentChar = wordsCurrentChar;
                    charIndex++;
                    patternNumberList.add(charIndex);
                    if (!charDictionaryIndex.containsKey(wordsCurrentChar)) {
                        charDictionaryIndex.put(wordsCurrentChar, charIndex);
                    }
                    continue;
                }
            }

            patternNumberList.add(charIndex);
        }

        return patternNumberList.toArray(new Integer[0]);
    }

}
