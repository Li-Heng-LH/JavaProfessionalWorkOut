package me.liheng.reviewQuestions;

import java.util.stream.Stream;

public class Review {

    public static void main(String[] args) {
        preVSpostIncrement();
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
}
