//package study.java.datastructure.algo.leetcode;
//
//// 1909
//// Easy
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class RemoveOneElementToMakeTheArrayStrictlyIncreasing {
//
//    public static void main(String[] args) {
//        int[] test1 = {2,3,1,2};
//        int[] test = {1,2,10,5,7};
//        System.out.println(canBeIncreasing(test));
//    }
//
//    public static boolean canBeIncreasing(int[] nums) {
//        List<Integer> list = new ArrayList<>();
//        Arrays.stream(nums).forEach(list::add);
//
//        int res = 0;
//
//        for (int i = 0; i < list.size(); i++) {
//            // Check after removing first element
//            if (i == 0 && i + 1 < list.size() && i + 2 < list.size()) {
//                if (list.get(i + 1) >= list.get(i + 2)) {
//                    res++;
//                }
//                // Check last element
//            } else if (i == list.size() - 1 && i - 1 >= 0 && i - 2 >= 0) {
//                if (list.get(i - 2) >= list.get(i - 1)) {
//                    res++;
//                }
//            } else {
//                if (list.get(i - 1) >= list.get(i + 1)) {
//                    res++;
//                }
//            }
//
//        }
//
//        return res <= 1;
//    }
//
//}