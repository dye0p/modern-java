package example.ex01;

import java.util.function.Function;

public class FunctionalInterfaceExample {

    public static void main(String[] args) {

        //익명 클래스 생성 ver
        Function<String, Integer> toInt = new Function<String, Integer>() {
            @Override
            public Integer apply(final String value) {
                return Integer.parseInt(value);
            }
        };
        final Integer numbers = toInt.apply("100");
        System.out.println(numbers);

        //람다식으로 변경 ver
        Function<String, Integer> toInt2 = (final String value) -> Integer.parseInt(value);

        final Integer numbers2 = toInt2.apply("100");
        System.out.println(numbers2);

        //Function.identity()
//        final Function<Integer, Integer> identity = Function.identity();
        final Function<Integer, Integer> identity = t -> t;

        System.out.println(identity.apply(100));

    }
}
