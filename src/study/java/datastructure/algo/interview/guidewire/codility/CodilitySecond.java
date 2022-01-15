package study.java.datastructure.algo.interview.guidewire.codility;

import java.util.HashMap;
import java.util.Map;

public class CodilitySecond {

    public static void main(String[] args) {
        int[] test1 = {4,4,3,3,1,0};
        int[] test2 = {};
        System.out.println(solution(test2));
    }

    public static int solution(int[] ranks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int tempInt : ranks) {
            map.put(tempInt, map.getOrDefault(tempInt, 0) + 1);
        }

        int reports = 0;

        for (int tempInt : map.keySet()) {
            if (map.containsKey(tempInt - 1)) {
                reports += map.get(tempInt - 1);
            }
        }

        return reports;
    }

}
