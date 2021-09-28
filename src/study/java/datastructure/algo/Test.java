package study.java.datastructure.algo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {

    int size = 5;

    int[] items = new int[5];

    public static void main(String[] args) {

        Test test = new Test();

        test.items[0] = 1;
        test.items[1] = 2;
        test.items[2] = 3;
        test.items[3] = 4;
        test.items[4] = 5;

        test.items[0] = test.items[--test.size];

        System.out.println(test.items[0]);
        System.out.println(test.size);

    }

}


