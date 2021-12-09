package me.liheng.reviewQuestions;

import java.util.stream.Stream;

public class Review {

    public static void main(String[] args) {
        question2();
    }

    private static void question1() {
        Stream<String> stream = Stream.iterate("", (s) -> s + "1");
        stream.limit(2).forEach(System.out::println);  // 1
    }

    private static void question2() {
        Stream<String> stream = Stream.generate(() -> "growl! ");
        stream.limit(3).forEach(System.out::println);
    }
}
