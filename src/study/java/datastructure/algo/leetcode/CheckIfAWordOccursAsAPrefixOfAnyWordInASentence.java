package study.java.datastructure.algo.leetcode;

// 1455
// Easy

public class CheckIfAWordOccursAsAPrefixOfAnyWordInASentence {

    public static void main(String[] args) {
        String sentence = "hello from the other side";
        String searchWord = "they";

        System.out.println(isPrefixOfWordWithoutUsingStartsWith(sentence, searchWord));
    }

    public static int isPrefixOfWordWithoutUsingStartsWith(String sentence, String searchWord) {
        String[] wordSplit = sentence.split(" ");

        // Loop over all the words in the sentence
        for (int i = 0; i < wordSplit.length; i++) {
            int searchWordCount = 0;
            for (int j = 0; j < searchWord.length(); j++) { // Loop over each character in the word
                // Check if the character doesn't match
                if (searchWord.length() > wordSplit[i].length())
                    break;
                if (wordSplit[i].charAt(j) != searchWord.charAt(j))
                    break;
                // Increase word count if it matches
                searchWordCount++;
                // If searchWordCount is equal to searchWord length, the prefix matches, break out of the loop
                if (searchWordCount == searchWord.length()) {
                    return i + 1;
                }

            }
        }
        return -1;
    }

    public static int isPrefixOfWordUsingStartsWith(String sentence, String searchWord) {
        String[] wordSplit = sentence.split(" ");

        for (int i = 0; i < wordSplit.length; i++) {
            if (wordSplit[i].startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }

}
