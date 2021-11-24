package study.java.datastructure.algo.leetcode.leetcode50;

// 49
// Medium

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        for (List<String> tempList : groupAnagrams(strs)) {
            for (String tempString :tempList)
                System.out.println(tempString);
            System.out.println();
        }
    }

    public static List<List<String>> groupAnagramsAlternative(String[] strs) {
        Map<String, List<String>> wordMap = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] current = strs[i].toCharArray();
            Arrays.sort(current);

            if (!wordMap.containsKey(Arrays.toString(current))) {
                List<String> newList = new ArrayList<>();
                newList.add(strs[i]);
                wordMap.put(Arrays.toString(current), newList);
            } else if (wordMap.containsKey(Arrays.toString(current))) {
                List<String> existingList = wordMap.get(Arrays.toString(current));
                existingList.add(strs[i]);
            }
        }

        return new ArrayList<>(wordMap.values());
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<Integer>> listMap = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] wordChar = strs[i].toCharArray();
            Arrays.sort(wordChar);

            if (listMap.containsKey(Arrays.toString(wordChar))) {
                ArrayList<Integer> existingList = listMap.get(Arrays.toString(wordChar));
                existingList.add(i);
            } else {
                ArrayList<Integer> newList = new ArrayList<>();
                newList.add(i);
                listMap.put(Arrays.toString(wordChar), newList);
            }
        }

        Iterator<ArrayList<Integer>> itr = listMap.values().iterator();
        List<List<String>> returningList = new ArrayList<>();
        int i = 0;

        while (itr.hasNext()) {
            ArrayList<Integer> iteratorList = itr.next();
            ArrayList<String> returningEachList = new ArrayList<>();

            for (Integer integer : iteratorList) {
                returningEachList.add(strs[integer]);
            }

            returningList.add(returningEachList);
        }

        return returningList;
    }

}
