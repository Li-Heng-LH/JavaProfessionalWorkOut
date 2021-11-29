package me.liheng.advancedStream;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AdvancedCollectors {

    public static void main(String[] args) {
        CollectingToMaps();
    }

    //Only applicable to Stream<String>
    private static void joining() {
        String str = Stream.of ("a", "b", "c")
                .collect(Collectors.joining());
        System.out.println(str);

        str = Stream.of ("a", "b", "c")
                .collect(Collectors.joining(","));  //smart, the last element will not have ,
        System.out.println(str);  //a,b,c
    }

    private static void averaging() {
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
        Double result = ohMy.collect(Collectors.averagingInt(String::length));
        System.out.println(result);
    }
    
    private static void CollectingToMaps() {
        //straightforward example
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
        Map<String, Integer> map = ohMy.collect(Collectors.toMap(s -> s, String::length));
        System.out.println(map);
    }
}
