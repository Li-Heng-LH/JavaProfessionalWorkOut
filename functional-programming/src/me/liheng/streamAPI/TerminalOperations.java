package me.liheng.streamAPI;

import java.util.Optional;
import java.util.stream.Stream;

public class TerminalOperations {

    public static void main(String[] args) {
        count();
        minmax();
        find();
        match();
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
}
