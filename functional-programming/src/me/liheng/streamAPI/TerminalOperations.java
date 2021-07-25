package me.liheng.streamAPI;

import java.util.Optional;
import java.util.stream.Stream;

public class TerminalOperations {

    public static void main(String[] args) {
        count();
        minmax();
        find();
        match();
        reduce();
    }

    // count() method determines the number of elements in a finite stream
    private static void count() {
        System.out.println(
                Stream.of(1, 2, 3)
                        .count()
        );
    }

    // min() and max() methods allow you to pass a custom comparator and find min/max
    private static void minmax() {
        Stream.of("monkey", "ape", "bonobo")
                .min((s1, s2) -> s1.length() - s2.length())  //returns Optional<String>
                .ifPresent(System.out::println);

        Optional<?> minEmpty = Stream.empty().min((s1, s2) -> 0);
        System.out.println(minEmpty.isPresent());
    }

    // return an element of the stream unless the stream is empty
    // findAny() is useful when you are working with a parallel stream
    // Not reductions, they sometimes return without processing all of the elements
    private static void find() {
        Stream.of(11, 22, 33)
                .findAny()
                .ifPresent(System.out::println);
        Stream.generate(() -> 99)
                .findAny()
                .ifPresent(System.out::println);
        System.out.println(Stream.empty()
                .findAny()
                .isPresent()
        );
    }

    private static void match() {
        System.out.println(
                Stream.of("a", "b", "c")
                .anyMatch(s -> s.equals("c"))
        );
    }

    // combines a stream into a single object
    private static void reduce() {

        // T reduce(T identity, BinaryOperator<T> accumulator)
        // lambda way
        System.out.println(
                Stream.of("w", "o", "l", "f")
                        .reduce("", (s1, s2) -> s1 + s2)
        );

        // Method reference
        // Instance methods on an instance to be passed in at runtime
        System.out.println(
                Stream.of("w", "o", "l", "f")
                        .reduce("", String::concat)
        );

        System.out.println(
                Stream.of(1, 2, 3, 4)
                        .reduce(1, (a,b) -> a * b)
        );

        System.out.println(
                Stream.of(1, 2, 3, 4)
                        .reduce(0, (a, b) -> a + b)
        );

        System.out.println(
                Stream.of(1, 2, 3, 4)
                        .reduce(0, Integer::min)
        );

        System.out.println(
                Stream.of(1, 2, 3, 4)
                        .reduce(0, Integer::sum)
        );

        // in case of empty Stream
        Stream<Integer> stream = Stream.empty();
        System.out.println(
                stream.reduce(1, (a,b) -> a * b) // 1
        );

        // in case of empty Stream
        Stream<? super Integer> stream2 = Stream.empty();
        System.out.println(
                // stream2.reduce(1, (a,b) -> a * b) // Compilation error
        );

        // in case of 1 element
        System.out.println(
                Stream.of(1)
                        .reduce(0, Integer::sum) // 1
        );

        // Optional<T> reduce(BinaryOperator<T> accumulator)
        //  * If the stream is empty, an empty Optional is returned.
        //  * If the stream has one element, it is returned.
        //  * If the stream has multiple elements, the accumulator is applied to combine them.
        Stream<Integer> stream3 = Stream.empty();
        System.out.println(
                stream3.reduce((a, b) -> a + b)
        );

        System.out.println(
                Stream.of(1).reduce((a, b) -> a + b)
        );

        // <U> U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)
        System.out.println(
                Stream.of(1, 2, 3, 4).reduce(0, Integer::sum, Integer::sum)
        );
    }
}
