package study.java.datastructure.algo.interview.xtremax;

public class first {

    public static int res = 0;

    public static void main(String[] args) {
        int test1 = 123;
        int test2 = 567;
        System.out.println(specialSummation(test2));
    }

    public static int specialSummation(int number) {
        String numberStr = String.valueOf(number);

        for (int i = 0; i < numberStr.length(); i++) {
            res += Integer.parseInt(String.valueOf(numberStr.charAt(i)));
        }

        if (res >= 10) {
            sum(res);
        }

        return res;
    }

    public static void sum(int number) {
        if (number < 10) {
            return;
        }

        int tempRes = 0;

        String numberStr = String.valueOf(number);
        for (int i = 0; i < numberStr.length(); i++) {
            tempRes += Integer.parseInt(String.valueOf(numberStr.charAt(i)));
        }

        res = tempRes;
        sum(res);
    }

}
