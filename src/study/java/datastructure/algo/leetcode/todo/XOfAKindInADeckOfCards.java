package study.java.datastructure.algo.leetcode.todo;

// 914
// Easy

import java.util.HashMap;
import java.util.Map;

public class XOfAKindInADeckOfCards {

    public static void main(String[] args) {

    }

    public static boolean hasGroupsSizeX(int[] deck) {
        if (deck.length < 2) {
            return false;
        }

        Map<Integer, Integer> deckMap = new HashMap<>();

        for (int tempInt : deck) {
            deckMap.put(tempInt, deckMap.getOrDefault(tempInt, 0) + 1);
        }

        boolean even = deckMap.get(deck[0]) % 2 == 0;

        return countDeck(deckMap, even);
    }

    public static boolean countDeck(Map<Integer, Integer> deckMap, boolean even) {
        if (even) {
            for (int mapVal : deckMap.values()) {
                if (mapVal == 1 || mapVal % 2 != 0) {
                    return false;
                }
            }
        } else {
            for (int mapVal : deckMap.values()) {
                if (mapVal == 1 || mapVal % 2 == 0) {
                    return false;
                }
            }
        }

        return true;
    }

}
