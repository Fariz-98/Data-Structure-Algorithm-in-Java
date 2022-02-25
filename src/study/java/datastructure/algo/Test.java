package study.java.datastructure.algo;

import java.util.function.Supplier;

public class Test {

    public static void main(String[] args) {

        Supplier<Integer> supplier = () -> 10;
        Supplier<Integer> supplier1 = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return 10;
            }
        };

        System.out.println(supplier.get());
    }

}