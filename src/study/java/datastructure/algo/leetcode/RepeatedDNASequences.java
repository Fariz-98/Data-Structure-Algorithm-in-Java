package study.java.datastructure.algo.leetcode;

// 187
// Medium

import java.util.*;

public class RepeatedDNASequences {

    public static void main(String[] args) {
        String s = "AAAAAAAAAAAAA";
        for (String tempStr : findRepeatedDnaSequences(s)) {
            System.out.println(tempStr);
        }
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> substringMap = new HashMap<>();
        List<String> res = new ArrayList<>();
        int startIndex = 0;
        int endIndex = 10;
        while (endIndex < s.length() + 1) {
            if (substringMap.containsKey(s.substring(startIndex, endIndex))) {
                substringMap.put(s.substring(startIndex, endIndex), substringMap.get(s.substring(startIndex, endIndex)) + 1);
                if (substringMap.get(s.substring(startIndex, endIndex)) < 2) {
                    res.add(s.substring(startIndex, endIndex));
                }
            } else {
                substringMap.put(s.substring(startIndex, endIndex), 0);
            }
            startIndex++;
            endIndex++;
        }

        return res;
    }

    public static List<String> findRepeatedDnaSequencesUsingRecursion(String s) {
        Map<String, Integer> substringMap = new HashMap<>();
        int startIndex = 0;
        int endIndex = 10;
        buildMap(startIndex, endIndex, s, substringMap);

        List<String> res = new ArrayList<>();
        for (String tempStr : substringMap.keySet()) {
            if (substringMap.get(tempStr) > 1) {
                res.add(tempStr);
            }
        }

        return res;
    }

    public static void buildMap(int startIndex, int endIndex, String s, Map<String, Integer> substringMap) {
        // Base case if endIndex is == s.length + 1 because substring is not inclusive
        if (endIndex == s.length() + 1) {
            return;
        }

        String currString = s.substring(startIndex, endIndex);
        substringMap.put(currString, substringMap.getOrDefault(currString, 0) + 1);

        buildMap(startIndex + 1, endIndex + 1, s, substringMap);
    }

}
