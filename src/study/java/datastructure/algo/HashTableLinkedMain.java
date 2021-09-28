package study.java.datastructure.algo;

import java.util.Scanner;

public class HashTableLinkedMain {
    WordList[] theArray;
    int arraySize;

    public String[][] elementsToAdd = {
            { "ace", "Very good" },
            { "act", "Take action" },
            { "add", "Join (something) to something else" },
            { "age", "Grow old" },
            { "ago", "Before the present" },
            { "aid", "Help, assist, or support" },
            { "aim", "Point or direct" },
            { "air", "Invisible gaseous substance" },
            { "all", "Used to refer to the whole quantity" },
            { "amp", "Unit of measure for the strength of an electrical current" },
            { "and", "Used to connect words" }, { "ant", "A small insect" },
            { "any", "Used to refer to one or some of a thing" },
            { "ape", "A large primate" },
            { "apt", "Appropriate or suitable in the circumstances" },
            { "arc", "A part of the circumference of a curve" },
            { "are", "Unit of measure, equal to 100 square meters" },
            { "ark", "The ship built by Noah" },
            { "arm", "Two upper limbs of the human body" },
            { "art", "Expression or application of human creative skill" },
            { "ash", "Powdery residue left after the burning" },
            { "ask", "Say something in order to obtain information" },
            { "asp", "Small southern European viper" },
            { "ass", "Hoofed mammal" },
            { "ate", "To put (food) into the mouth and swallow it" },
            { "atm", "Unit of pressure" },
            { "awe", "A feeling of reverential respect" },
            { "axe", "Edge tool with a heavy bladed head" },
            { "aye", "An affirmative answer" } };

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        HashTableLinkedMain hashTable = new HashTableLinkedMain(11);
        hashTable.addTheArray(hashTable.elementsToAdd);

        String wordLookup = "a";

        while (!wordLookup.equalsIgnoreCase("x")) {
            System.out.println(": ");

            wordLookup = input.nextLine();

            System.out.println(hashTable.find(wordLookup));
        }

        hashTable.displayTheArray();
    }

    public HashTableLinkedMain(int size) {
        arraySize = size;

        theArray = new WordList[size];

        for (int i = 0; i < size; i++) {
            theArray[i] = new WordList();
        }
    }

    // Algorithm = (hashValue * 27 + charcode) % arraySize;
    // This method will find the array index
    // It hashes the character in each of the string and returns the final value
    public int stringHashFunction(String wordToHash) {
        int HashValue = 0;

        for (int i = 0; i < wordToHash.length(); i++) {
            int charCode = wordToHash.charAt(i) - 96;
            HashValue = (HashValue * 27 + charCode) % arraySize;
        }

        return HashValue;
    }

    // Add elements of a 2d array using the insert method
    public void addTheArray(String[][] elementsToAdd) {
        for (int i = 0; i < elementsToAdd.length; i++) {
            String word = elementsToAdd[i][0];
            String definition = elementsToAdd[i][1];

            Word newWord = new Word(word, definition);

            insert(newWord);
        }
    }

    // Insert element at the end of a linkedlist inside of its index
    public void insert(Word newWord) {
        int index = stringHashFunction(newWord.theWord);

        theArray[index].insert(newWord);
    }

    // Find the matching words and their definition (key, value)
    public Word find(String wordsToFind) {
        int index = stringHashFunction(wordsToFind);

        return theArray[index].find(wordsToFind);
    }

    // Display all elements at each index
    public void displayTheArray() {
        for (int i = 0; i < arraySize; i++) {
            System.out.println("Words at index: " + i);
            theArray[i].displayWordList();
        }
    }
}

class WordList {
    public Word firstWord;

    // Insert word at the end of the list or at the first spot
    public void insert(Word newWord) {
        Word current = firstWord;
        Word previous = null;

        if (firstWord == null) {
            firstWord = newWord;
        } else {
            while (current != null) {
                previous = current;
                current = current.next;
            }
            current = newWord;
            previous.next = current;
        }
    }

    // Display all Words inside the list
    public void displayWordList() {
        Word current = firstWord;

        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }

    // Find a word inside the list
    public Word find(String wordToFind) {
        Word current = firstWord;

        while (current != null) {
            if (current.theWord.equals(wordToFind)) {
                return current;
            }

            current = current.next;
        }
        System.out.println("Word not found");
        return null;
    }
}

// The element that we want to put into our word list hash table
class Word {
    public String theWord;
    public String defintion;
    public Word next;

    public Word(String theWord, String definition) {
        this.theWord = theWord;
        this.defintion = definition;
    }

    public String toString() {
        return theWord + " : " + defintion;
    }
}
