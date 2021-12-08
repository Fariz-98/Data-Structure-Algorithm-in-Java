package study.java.datastructure.algo.leetcode.todo.optimize;

// 848
// Medium

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShiftingLetters {

    public static void main(String[] args) {
        String s = "zvhez";
        int[] shifts = {10,16,10,26,26};
        System.out.println(shiftingLetters(s, shifts));
    }

    public static String shiftingLetters(String s, int[] shifts) {
        HashMap<Character, Long> alphabetLib = new HashMap<>();
        Character alphabetLibChar = 'a';
        for (Long i = 1L; i < 27; i++, alphabetLibChar++) {
            alphabetLib.put(alphabetLibChar, i);
        }
        System.out.println(alphabetLib);

        HashMap<Long, Character> alphabetLibTranslated = new HashMap<>();
        Character alphabetLibTranslatedChar = 'a';
        for (Long i = 1L; i < 27; i++, alphabetLibTranslatedChar++) {
            alphabetLibTranslated.put(i, alphabetLibTranslatedChar);
        }

        List<Long> sToLong = new ArrayList<>();
        for (Character tempChar : s.toCharArray()) {
            sToLong.add(alphabetLib.get(tempChar));
        }

        // Backwards list
        List<Long> toAddToChar = new ArrayList<>();
        Long currSum = 0L;
        for (int i = shifts.length - 1; i >= 0; i--) {
            currSum += shifts[i];
            if (currSum > 26) {
                Long remainder = currSum % 26L;
                toAddToChar.add(remainder);
                continue;
            }
            toAddToChar.add(currSum);
        }

        StringBuilder returningString = new StringBuilder();
        int toAddIndex = toAddToChar.size() - 1;
        for (int i = 0; i < sToLong.size(); i++) {
            Long currChar = sToLong.get(i) + toAddToChar.get(toAddIndex);
            if (currChar > 26) {
                currChar = currChar - 26;
            }
            returningString.append(alphabetLibTranslated.get(currChar));
            toAddIndex--;
        }

        return returningString.toString();
    }

}
