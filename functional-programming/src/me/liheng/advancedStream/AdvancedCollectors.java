package me.liheng.advancedStream;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
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
        System.out.println(map); //{lions=5, bears=5, tigers=6}

        //What if there are repetitive keys?
        ohMy = Stream.of("lions", "tigers", "bears");
        Map<Integer, String> map2 = ohMy.collect(Collectors.toMap(
                String::length,
                s -> s,
                (s1, s2 )-> s1 + "," + s2));
        System.out.println(map2); //{5=lions,bears, 6=tigers}

        ohMy = Stream.of("lions", "tigers", "bears");
        Map<Integer, String> map3 = ohMy.collect(Collectors.toMap(
                String::length,
                s -> s,
                String::concat,
                TreeMap::new));
        System.out.println(map3); // {5=lionsbears, 6=tigers}
        System.out.println(map3.getClass()); // class java.util.TreeMap
    }
    
    private static void groupingBy() {
        //groupingBy(classifier)  -> Map<K, List<T>>
        //classifier maps elements to some key type K
        //collector produces a Map<K, List<T>>
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
        Map<Integer, List<String>> map = ohMy.collect(Collectors.groupingBy(String::length));
        System.out.println(map); // {5=[lions, bears], 6=[tigers]}
    }
}
