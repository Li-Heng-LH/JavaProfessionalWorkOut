package me.liheng.streamAPI;

import java.util.stream.Stream;

public class IntermediateOperations {

    public static void main(String[] args) {
        filter();
    }

    //Stream<T> filter(Predicate<? super T> predicate)
    private static void filter() {
        Stream.of("monkey", "gorilla", "bonobo")
                .filter(x -> x.startsWith("m"))
                //Static method format
                .forEach(System.out::println);
    }
}
