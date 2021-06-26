package me.liheng.java8Additions;

import java.util.Arrays;
import java.util.List;

public class LoopingThrough {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("A", "B", "C");
        list.forEach(s -> System.out.println(s));

        list.forEach(System.out::println);
    }
}
