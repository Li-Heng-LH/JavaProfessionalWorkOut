package me.liheng.streamAPI;

import java.util.stream.Stream;

public class IntermediateOperations {

    public static void main(String[] args) {
        filter();

        System.out.println("\ndistinct:");
        distinct();

        System.out.println("\nskip:");
        skip();

    }

    //Stream<T> filter(Predicate<? super T> predicate)
    private static void filter() {
        Stream.of("monkey", "gorilla", "bonobo")
                .filter(x -> x.startsWith("m"))
                //Static method format
                .forEach(System.out::println);
    }

    //Stream<T> distinct()
    private static void distinct() {
        Stream<String> s = Stream.of("duck", "duck", "duck", "goose");
        s.distinct()
                .forEach(System.out::println);
    }

    private static void skip() {
        Stream<Integer> s = Stream.iterate(1, n -> n+1);
        s.skip(5)
                .limit(2)
                .forEach(System.out::println);
    }
}
