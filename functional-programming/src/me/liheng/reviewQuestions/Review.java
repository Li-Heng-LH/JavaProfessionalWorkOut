package me.liheng.reviewQuestions;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Review {

    public static void main(String[] args) {
        partitioningVSGrouping();
    }

    private static void question1() {
        Stream<String> stream = Stream.iterate("", (s) -> s + "1");
        stream.limit(2).forEach(System.out::println);  // 1
    }

    private static void question2() {
        Stream<String> stream = Stream.generate(() -> "growl! ");
        stream.limit(3).forEach(System.out::println);
    }
    
    private static void preVSpostIncrement() {
        // post: the returned value is x itself
        Stream.iterate(1, x -> x++)
                .limit(3)
                .forEach(System.out::println);

        System.out.println();

        // pre: the returned value is the incremented x
        Stream.iterate(1, x -> ++x)
                .limit(3)
                .forEach(System.out::println);

        System.out.println();

        int t = 88;
        int r = t++;
        int s = ++t;
        System.out.println(r); // 88
        System.out.println(s); // 90
    }

    private static void partitioningVSGrouping() {
        Stream<String> s = Stream.empty();
        Stream<String> s2 = Stream.empty();

        Map<Boolean, List<String>> p = s.collect(
                Collectors.partitioningBy(x -> x.startsWith("A"))
        );

        Map<Boolean, List<String>> q = s2.collect(
                Collectors.groupingBy(x -> x.startsWith("A"))
        );

        System.out.println(p + " " + q);  // {false=[], true=[]} {}

        //partitioningBy() operation always returns a map with two Boolean keys,
        //even if there are no corresponding values.
        //By contrast, groupingBy() returns only keys that are actually needed.
    }
}
