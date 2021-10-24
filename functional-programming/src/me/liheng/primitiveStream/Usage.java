package me.liheng.primitiveStream;

import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Usage {

    public static void main(String[] args) {

        //To sum an Integer stream:
        Stream<Integer> stream = Stream.of(1, 2, 3);
        System.out.println(
                stream.reduce(0, (s, n) -> s + n)
        );

        //To sum an integer stream:
        Stream<Integer> s = Stream.of(1, 2, 3);
        System.out.println(
                s.mapToInt(x -> x)
                .sum()
        );

        //Use integer Stream to calculate avg
        IntStream intStream = IntStream.of(1, 2, 3);
        OptionalDouble avg = intStream.average();
        System.out.println(avg.getAsDouble());

        System.out.println();
        DoubleStream doubleStream = DoubleStream.of(1, 2, 3);
        doubleStream.forEach(System.out::println);
    }
}
