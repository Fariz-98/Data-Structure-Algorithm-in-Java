package study.java.datastructure.algo;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        PriorityQueue<Integer> testQ = new PriorityQueue<>();
        testQ.add(5);
        testQ.add(3);
        testQ.add(7);
        testQ.add(2);

        System.out.println(testQ.peek());
    }

}