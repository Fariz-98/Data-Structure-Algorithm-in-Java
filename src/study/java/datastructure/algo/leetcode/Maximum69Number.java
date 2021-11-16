package study.java.datastructure.algo.leetcode;

// 1323
// Easy

public class Maximum69Number {

    public static void main(String[] args) {

    }

    public static int maximum69Number(int num) {
        if (num == 9999) {
            return num;
        }

        StringBuilder nums = new StringBuilder(String.valueOf(num));

        for (int i = 0; i < nums.length(); i++) {
            if (nums.charAt(i) == ('6')) {
                nums.setCharAt(i, '9');
                break;
            }
        }
        return Integer.parseInt(nums.toString());
    }

}
