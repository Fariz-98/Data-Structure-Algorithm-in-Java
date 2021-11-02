package study.java.datastructure.algo.leetcode.todo.notaccepted;

// 848
// Medium
// TODO: Time limit exceeded

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShiftingLetters {

    public static void main(String[] args) {
        String s = "z";
        int[] shifts = {537330785};
        System.out.println(shiftingLetters(s, shifts));
    }

    public static String shiftingLetters(String s, int[] shifts) {
        StringBuilder stringBuilder = new StringBuilder();

        HashMap<Character, Integer> alphabetLib = new HashMap<>();
        Character alphabetLibChar = 'a';
        for (int i = 1; i < 27; i++, alphabetLibChar++) {
            alphabetLib.put(alphabetLibChar, i);
        }

        HashMap<Integer, Character> alphabetLibTranslated = new HashMap<>();
        Character alphabetLibTranslatedChar = 'a';
        for (int i = 1; i < 27; i++, alphabetLibTranslatedChar++) {
            alphabetLibTranslated.put(i, alphabetLibTranslatedChar);
        }

        List<Integer> sToInteger = new ArrayList<>();
        for (Character tempChar : s.toCharArray()) {
            sToInteger.add(alphabetLib.get(tempChar));
        }

        int shiftUntil = 1;
        for (int i = 0; i < shifts.length; i++) {
            for (int j = 0; j < shiftUntil && j < sToInteger.size(); j++) {
                int currentChar = sToInteger.remove(j);
                int toAdd = shifts[i];
                int remainder = 0;

                if (toAdd > 26) {
                    remainder = toAdd % 26;
                    currentChar += remainder;
                } else {
                    currentChar += toAdd;
                }

                while (currentChar > 26) {
                    int leftOver = currentChar - 26;
                    currentChar = 0 + leftOver;
                }

                sToInteger.add(j, currentChar);
            }
            shiftUntil++;
        }

        for (int i = 0; i < sToInteger.size(); i++) {
            stringBuilder.append(alphabetLibTranslated.get(sToInteger.get(i)));
        }

        return stringBuilder.toString();
    }

}
