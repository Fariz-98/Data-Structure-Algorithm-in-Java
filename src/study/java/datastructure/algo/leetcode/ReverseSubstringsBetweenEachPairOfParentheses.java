package study.java.datastructure.algo.leetcode;

// TODO: FIX THIS
// THIS IS WRONG

import java.util.*;

public class ReverseSubstringsBetweenEachPairOfParentheses {

    public static void main(String[] args) {
        String a = "a(bcdefghijkl(mno)p)q";
        String b = "(u(love)i)";

        reverseParentheses(b);
    }

    public static String reverseParentheses(String s) {
        // Put the word in a stack
        Stack<String> wordStack = new Stack<>();
        List<String> wordList = new ArrayList<>();

        // Convert s to list because i want to use an iterator to iterate over the string
        List<Character> charList = new ArrayList<>();
        for (Character tempChar : s.toCharArray())
            charList.add(tempChar);

        // Iterate over each character looking for parentheses
        Iterator<Character> charItr = charList.iterator();

        // Build a string to store each word in a stack
        StringBuilder wordBuilder = new StringBuilder();
        boolean endOfWord = false;


        if (charList.get(0) != '(') {
            while (true) {
                String currentChar = charItr.next().toString();
                if (currentChar.equals("(")) {
                    wordStack.push(wordBuilder.toString());
                    wordBuilder = new StringBuilder();
                    break;
                }
                wordBuilder.append(currentChar);
            }
        }

        while (charItr.hasNext()) {
            String currentChar = charItr.next().toString();

            if (!endOfWord) {
                if (currentChar.equals(")")) {
                    endOfWord = true;
                    wordList.add(wordBuilder.toString());
                    wordBuilder = new StringBuilder();
                    continue;
                }

                if (!currentChar.equals("(")) {
                    wordBuilder.append(currentChar);
                    System.out.println(wordBuilder);
                    continue;
                } else {
                    wordStack.push(wordBuilder.toString());
                    wordBuilder = new StringBuilder();
                    continue;
                }
            }

            if (!currentChar.equals(")")) {
                wordBuilder.append(wordStack.pop());
                wordBuilder.append(currentChar);
                wordStack.push(wordBuilder.toString());
                wordBuilder = new StringBuilder();
            } else {
                wordList.add(wordStack.pop());
            }
        }

        System.out.println();
        for (String tempStr : wordList) {
            System.out.println(tempStr);
        }

        return "a";
    }

    public static String reverseWord(String s) {
        List<Character> reverseUsingList = new ArrayList<>();

        for (Character tempChar : s.toCharArray())
            reverseUsingList.add(tempChar);

        Collections.reverse(reverseUsingList);

        StringBuilder charToString = new StringBuilder();

        for (Character tempChar : reverseUsingList)
            charToString.append(tempChar);

        return charToString.toString();
    }
}
