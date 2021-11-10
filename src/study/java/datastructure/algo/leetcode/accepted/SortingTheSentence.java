package study.java.datastructure.algo.leetcode.accepted;

// 1859
// Easy

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingTheSentence {

    public static void main(String[] args) {
        String s = "Myself2 Me1 I4 and3";
        System.out.println(sortSentence(s));
    }

    public static String sortSentence(String s) {
        List<String> stringList = new ArrayList<>();
        for (String tempString : s.split(" "))
            stringList.add(tempString);

        Collections.sort(stringList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int o1Num = o1.charAt(o1.length() - 1);
                int o2Num = o2.charAt(o2.length() - 1);

                if (o1Num > o2Num) {
                    return 1;
                } else if (o1Num < o2Num){
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        StringBuilder cleanedString = new StringBuilder();

        for (int i = 0; i < stringList.size(); i++) {
            cleanedString.append(stringList.get(i));
            cleanedString.deleteCharAt(cleanedString.length() - 1);
            if (i == stringList.size() - 1) {
                break;
            }
            cleanedString.append(" ");
        }

        return cleanedString.toString();
    }

}
