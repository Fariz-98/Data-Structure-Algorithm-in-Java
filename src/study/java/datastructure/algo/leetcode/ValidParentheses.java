package study.java.datastructure.algo.leetcode;

// 20
// Easy
/*
Note:
If the string starts with an opening parentheses, it gets put in the stack, else it checks the top of the stack, if it's
the same closing ones, the boolean status is true, else it's false and it gets returned as is.

Edge cases:
If the last character is checked with the stack as true and there is a leftover character in the stack, it will also
be returned as true, so there is a final if at the end to ensure that the stack is empty.

When peeking inside the stack, it might also be empty which means it has ran out of opening parentheses while there are
more closing ones, this will result in an exception so there is also a check to make sure that the stack is not empty
while peeking. If it is, it will be returned as false.
 */

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        String s = "({[)";
        String t = "([]){";
        // stack = )}
        System.out.println(isValid(t));
    }

    public static boolean isValid(String s) {
        Stack<Character> leftStack = new Stack<>();
        boolean valid = false;

        if (!s.startsWith("(") && !s.startsWith("{") && !s.startsWith("["))
            return false;

        for (int i = 0; i < s.length(); i++) {
            if (i != s.length() - 1 && (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')) {
                leftStack.push(s.charAt(i));
            } else if (s.charAt(i) == ')' && !leftStack.empty() && leftStack.peek() == '(') {
                valid = true;
                leftStack.pop();
            } else if (s.charAt(i) == '}' && !leftStack.empty() && leftStack.peek() == '{') {
                valid = true;
                leftStack.pop();
            } else if (s.charAt(i) == ']' && !leftStack.empty() && leftStack.peek() == '[') {
                valid = true;
                leftStack.pop();
            } else {
                return false;
            }
        }

        if (!leftStack.empty())
            return false;

        return valid;
    }

}
