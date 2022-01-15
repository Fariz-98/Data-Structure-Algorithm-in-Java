package study.java.datastructure.algo.interview.xtremax;

import java.util.HashMap;
import java.util.Map;

public class five {

    public static void main(String[] args) {
        String test = "app";
        String test2 = "apps";
        String test3 = "aammdd";
        String test4 = "hhhhffffnnnnddddjjjjkkkkeeeew";

        System.out.println(palindromeAble(test3));
    }

    public static String palindromeAble(String input) {
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : input.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        boolean isOdd = input.length() % 2 != 0;

        if (!isOdd) {
            for (char ch : map.keySet()) {
                if (map.get(ch) % 2 != 0) {
                    return "false";
                }
            }
        } else {
            int oddCharCount = 0;
            for (char ch : map.keySet()) {
                if (map.get(ch) % 2 != 0) {
                    oddCharCount++;
                }

                if (oddCharCount > 1) {
                    return "false";
                }
            }
        }

        StringBuilder forwardStr = new StringBuilder();
        StringBuilder backwardStr = new StringBuilder();
        StringBuilder middle = new StringBuilder();

        for (char ch : map.keySet()) {
            if (map.get(ch) % 2 != 0) {
                middle.append(ch);
                continue;
            }

            int charCount = map.get(ch);
            for (int i = 0; i < charCount / 2; i++) {
                forwardStr.append(ch);
                backwardStr.append(ch);
                System.out.println(forwardStr);
                System.out.println(backwardStr);
            }
        }

        forwardStr.append(middle).append(backwardStr.reverse());
        return forwardStr.toString();
    }

}
