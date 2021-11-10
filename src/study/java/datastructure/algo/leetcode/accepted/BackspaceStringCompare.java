package study.java.datastructure.algo.leetcode.accepted;

// 844
// Easy

import java.util.Stack;

public class BackspaceStringCompare {

    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ad#c"));
    }

    public static boolean backspaceCompare(String s, String t) {
        StringBuilder firstWord = new StringBuilder();
        StringBuilder secondWord = new StringBuilder();
        Stack<Character> firstWordStack = new Stack<>();
        Stack<Character> secondWordStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#') {
                firstWordStack.push(s.charAt(i));
            } else if (s.charAt(i) == '#') {
                if (firstWordStack.empty()) {
                    continue;
                }
                firstWordStack.pop();
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) != '#') {
                secondWordStack.push(t.charAt(i));
            } else if (t.charAt(i) == '#') {
                if (secondWordStack.empty()) {
                    continue;
                }
                secondWordStack.pop();
            }
        }

        for (Character character : firstWordStack) {
            firstWord.append(character);
        }

        for (Character character : secondWordStack) {
            secondWord.append(character);
        }

        return firstWord.toString().equals(secondWord.toString());
    }

}

