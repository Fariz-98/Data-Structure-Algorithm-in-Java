package study.java.datastructure.algo;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        String a = "abcdefghijklab";
        String b = "abcdefghijkabl";

        System.out.println(Arrays.equals(buildPattern(a), buildPattern(b)));

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


