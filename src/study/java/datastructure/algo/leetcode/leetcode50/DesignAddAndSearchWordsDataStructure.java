package study.java.datastructure.algo.leetcode.leetcode50;

// 211
// Medium

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class DesignAddAndSearchWordsDataStructure {

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");
        System.out.println(wordDictionary.search("a"));
        System.out.println(wordDictionary.search(".at"));
        wordDictionary.addWord("bat");
        System.out.println(wordDictionary.search(".at"));
        System.out.println(wordDictionary.search("an."));
        System.out.println(wordDictionary.search("a.d."));
        System.out.println(wordDictionary.search("b."));
        System.out.println(wordDictionary.search("a.d"));
        System.out.println(wordDictionary.search("."));

    }

}

class WordDictionary {

    private Node root;

    public WordDictionary() {
        root = new Node(Character.MIN_VALUE);
    }

    public void addWord(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);

            if (curr.children[currChar - 'a'] == null) {
                curr.children[currChar - 'a'] = new Node(currChar);
            }

            curr = curr.children[currChar - 'a'];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        return dfs(root, 0, word);
    }

    // Backtrack dfs
    public boolean dfs(Node root, int start, String word) {
        if (start == word.length() && root.isWord) {
            return true;
        }

        if (word.isEmpty() || start == word.length()) {
            return false;
        }

        boolean res = false;
        char currChar = word.charAt(start);
        if (currChar == '.') {
            for (int i = 0; i < root.children.length; i++) {
                if (root.children[i] != null) {
                    if (dfs(root.children[i], start + 1, word))
                        res = true;
                }
            }
        } else {
            if (root.children[currChar - 'a'] != null) {
                res = dfs(root.children[currChar - 'a'], start + 1, word);
            }
        }

        return res;
    }

}

class Node {

    public char c;
    public Node[] children;
    public boolean isWord;

    public Node(char c) {
        this.c = c;
        children = new Node[26];
        isWord = false;
    }

}























