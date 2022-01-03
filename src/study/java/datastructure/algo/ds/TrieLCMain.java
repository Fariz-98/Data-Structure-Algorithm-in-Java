package study.java.datastructure.algo.ds;

// Trie DS for lowercase char (LC)

public class TrieLCMain {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abc");
        System.out.println(trie.search("a"));
        System.out.println(trie.search("abc"));
        System.out.println(trie.search("bc"));
        System.out.println(trie.search("d"));
    }

}

class Trie {

    private TrieNode root = new TrieNode(Character.MIN_VALUE);

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);

            // If current node !contains currChar, add to children, else do nothing and move current.
            /*
             * currChar - 'a' will return the index of the character
             * For example, 'a' - 'a' will return 0, 'b' - 'a' will return 1, etc.
             */
            if (current.children[currChar - 'a'] == null) {
                current.children[currChar - 'a'] = new TrieNode(currChar);
            }

            // Move current to the next character that's in the string
            current = current.children[currChar - 'a'];
        }

        // Finally, mark the final char in the string as isWord
        current.isWord = true;
    }

    public boolean search(String word) {
        TrieNode node = searchWord(word);
        if (node != null && node.isWord) {
            return true;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = searchWord(prefix);
        if (node != null) {
            return true;
        }
        return false;
    }

    /*
     * Both search and startsWith can be done using one helper method because they both go through the trie
     */
    public TrieNode searchWord(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);

            // Same logic as insert
            if (current.children[currChar - 'a'] == null) {
                return null;
            }

            current = current.children[currChar - 'a'];
        }

        return current;
    }

}

class TrieNode {

    public char c;
    public boolean isWord;
    public TrieNode[] children;

    public TrieNode(Character c) {
        this.c = c;
        isWord = false;
        children = new TrieNode[26];
    }

}
