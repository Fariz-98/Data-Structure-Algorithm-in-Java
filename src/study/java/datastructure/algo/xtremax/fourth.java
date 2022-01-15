package study.java.datastructure.algo.xtremax;

import java.util.ArrayList;
import java.util.List;

public class fourth {

    public static void main(String[] args) {
        List<Integer> test = List.of(1,1,1);
        for (int tempInt : generateNLengthSequence(5, test)) {
            System.out.println(tempInt);
        }
    }

    public static List<Integer> generateNLengthSequence(int n, List<Integer> differenceSequence) {
        List<Integer> tempList = new ArrayList<>();

        // Add initial number to tempList
        int tempNum = 1;
        tempList.add(tempNum);
        for (int i = 0; i < differenceSequence.size(); i++) {
            tempNum += differenceSequence.get(i);
            tempList.add(tempNum);
        }

        List<Integer> currList = new ArrayList<>();
        while (tempList.size() != n) {
            currList = new ArrayList<>();
            int newTemp = 1;
            currList.add(newTemp);
            for (int i = 0; i < tempList.size(); i++) {
                newTemp += tempList.get(i);
                currList.add(newTemp);
            }

            tempList = new ArrayList<>(currList);
        }

        return currList;
    }

}
