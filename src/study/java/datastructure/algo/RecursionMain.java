package study.java.datastructure.algo;

public class RecursionMain {

    public static void main(String[] args) {

        RecursionClass recurse = new RecursionClass();

        System.out.println(recurse.factorial(5));
    }
}

class RecursionClass {

    public int factorial(int number) {

        if (number == 1)
            return 1;
        else
            return number = number * factorial(number - 1);
    }
}


