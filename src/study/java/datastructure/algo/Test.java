package study.java.datastructure.algo;

import java.util.*;

public class Test {

    public static void main(String[] args) {

        String allowed = "abc";
        String[] words = {"a","b","c","ab","ac","bc","abc"};

        HashSet<Character> test = new HashSet<>();
        HashSet<Character> allowedSet = new HashSet<>();

        for (int l = 0; l < allowed.length(); l++) {
            allowedSet.add(allowed.charAt(l));
        }

        for (int i = 0; i < words[4].length(); i++) {
            test.add(words[4].charAt(i));
        }

        System.out.println(allowedSet.contains(words[4].charAt(1)));

    }

}


