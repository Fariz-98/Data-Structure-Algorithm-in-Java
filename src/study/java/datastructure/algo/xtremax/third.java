package study.java.datastructure.algo.xtremax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class third {

    public static int level = 0;

    public static void main(String[] args) {
        List<Integer> test1 = List.of(
                1,2,3,4,5
        );
        List<Integer> test2 = List.of(
                1,2,4,7,11
        );

        System.out.println(getLevelOfDifferences(test2));
    }

    public static int getLevelOfDifferences(List<Integer> sequence) {
        ArrayList<Integer> tempSequence = new ArrayList<>(sequence);

        boolean contains = false;
        for (int i = 0; i < tempSequence.size(); i++) {
            if (i + 1 < tempSequence.size() - 1 && !Objects.equals(tempSequence.get(i), tempSequence.get(i + 1))) {
                contains = true;
                break;
            }
        }

        if (contains) {
            for (int i = tempSequence.size() - 1; i > 0; i--) {
                int currVal = tempSequence.get(i);
                int prevVal = tempSequence.get(i - 1);
                tempSequence.set(i, currVal - prevVal);
            }
            level++;
            tempSequence.remove(0);
        } else {
            return level;
        }

        getLevelOfDifferences(tempSequence);
        return level;
    }

}
