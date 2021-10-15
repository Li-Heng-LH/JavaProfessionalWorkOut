package me.liheng.streamAPI;

import java.util.Arrays;
import java.util.List;

public class Pipeline {

    public static void main(String[] args) {
        ex1();
    }

    private static void ex1() {
        //get the first two names alphabetically that are four characters long
        List<String> list = Arrays.asList("Toby", "Anna", "Leroy", "Alex");

        list.stream()
                .filter(s -> s.length() == 4)
                .sorted()   //sorted() can’t sort yet because it needs all of the data
                .limit(2)   //limit()  remembers the number of elements seen
                .forEach(System.out::println);
    }
}
