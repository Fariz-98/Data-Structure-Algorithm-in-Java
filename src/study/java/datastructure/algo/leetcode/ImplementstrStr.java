package study.java.datastructure.algo.leetcode;

// 28
// Easy

import java.util.ArrayList;
import java.util.List;

public class ImplementstrStr {

    public static void main(String[] args) {
        String hay1 = "hello";
        String need1 = "ll";

        String hay2 = "mississippi";
        String need2 = "issip";
        System.out.println(strStr(hay2, need2));
    }

    public static int strStr(String haystack, String needle) {
        // Add all index of char that starts with needle first char
        // Build string starting from each index
        if (needle.equals("")) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }

        List<Integer> indexList = new ArrayList<>();
        char needleFirst = needle.charAt(0);
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needleFirst) {
                indexList.add(i);
            }
        }

        // Build string for each
        for (int i = 0; i < indexList.size(); i++) {
            int needleIndex = 0;
            int currentStartIndex = indexList.get(i);

            // Check last char
            if ((currentStartIndex + needle.length() - 1 < haystack.length() &&
            haystack.charAt(currentStartIndex + needle.length() - 1) != needle.charAt(needle.length() - 1)) ||
            currentStartIndex + needle.length() - 1 > haystack.length()) {
                continue;
            }

            StringBuilder strBuilder = new StringBuilder();

            while (currentStartIndex < haystack.length() && needleIndex < needle.length()) {
                if (haystack.charAt(currentStartIndex) != needle.charAt(needleIndex)) {
                    break;
                }

                strBuilder.append(haystack.charAt(currentStartIndex));
                currentStartIndex++;
                needleIndex++;
            }

            if (strBuilder.toString().equals(needle)) {
                return indexList.get(i);
            }
        }

        return -1;
    }

}
