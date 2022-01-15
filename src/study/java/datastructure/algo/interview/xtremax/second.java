package study.java.datastructure.algo.interview.xtremax;

public class second {

    public static int res = 1;

    public static void main(String[] args) {
        int test1 = 123;
        int test2 = 567;
        System.out.println(specialMultiplication(test1));
    }

    public static int specialMultiplication(int number) {
        String numberStr = String.valueOf(number);
        for (int i = 0; i < numberStr.length(); i++) {
            res *= Integer.parseInt(String.valueOf(numberStr.charAt(i)));
        }

        if (res >= 10) {
            multiply(res);
        }

        return res;
    }

    public static void multiply(int number) {
        if (number < 10) {
            return;
        }

        int tempRes = 1;

        String numberStr = String.valueOf(number);
        for (int i = 0; i < numberStr.length(); i++) {
            tempRes *= Integer.parseInt(String.valueOf(numberStr.charAt(i)));
        }

        res = tempRes;
        multiply(res);
    }

}
