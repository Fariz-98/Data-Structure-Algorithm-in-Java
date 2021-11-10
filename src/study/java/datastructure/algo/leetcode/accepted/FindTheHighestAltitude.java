package study.java.datastructure.algo.leetcode.accepted;

// 1732
// Easy

public class FindTheHighestAltitude {

    public static void main(String[] args) {
        int[] gain = {-4,-3,-2,-1,4,3,2};
        System.out.println(largestAltitude(gain));
    }

    public static int largestAltitude(int[] gain) {
        int largest = 0;
        int tracker = 0;

        for (int i = 0; i < gain.length; i++) {
            tracker += gain[i];
            if (tracker > largest)
                largest = tracker;
        }
        return largest;
    }

}
