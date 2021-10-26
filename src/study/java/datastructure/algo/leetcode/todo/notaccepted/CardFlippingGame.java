package study.java.datastructure.algo.leetcode.todo.notaccepted;

// 822
// Medium
// TODO: WRONG ANSWER

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CardFlippingGame {

    public static void main(String[] args) {
        int[] fronts = {1, 2, 4, 4, 7};
        int[] backs = {1, 3, 4, 1, 3};

        System.out.println(flipgame(fronts, backs));
    }

    public static int flipgame(int[] fronts, int[] backs) {
        int returnInt = 0;

        // Create two lists, one for the front, one for the back
        List<Integer> cardFront = new ArrayList<>();
        for (Integer tempInt : fronts)
            cardFront.add(tempInt);

        List<Integer> cardBack = new ArrayList<>();
        for (Integer tempInt : backs)
            cardBack.add(tempInt);

        for (int i = 0; i < cardBack.size(); i++) {
            // Check if the front and the back has the same number
            if (cardFront.get(i) == cardBack.get(i)) {
                continue;
            }

            // Check for the front number
            int frontRemoved = cardFront.remove(i);
            if (!cardFront.contains(frontRemoved) && !cardBack.contains(frontRemoved)) {
                if (returnInt == 0) {
                    returnInt = frontRemoved;
                } else if (frontRemoved < returnInt) {
                    returnInt = frontRemoved;
                }

            }
            cardFront.add(i, frontRemoved);

            // Check for the back number
            int backRemoved = cardBack.remove(i);
            if (!cardFront.contains(backRemoved) && !cardBack.contains(backRemoved)) {
                if (returnInt == 0) {
                    returnInt = backRemoved;
                } else if (backRemoved < returnInt) {
                    returnInt = backRemoved;
                }
            }
            cardBack.add(i, backRemoved);
        }
        return returnInt;
    }

}
