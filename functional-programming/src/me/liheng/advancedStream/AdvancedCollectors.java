package me.liheng.advancedStream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AdvancedCollectors {

    public static void main(String[] args) {
        minBy();
    }

    //Only applicable to Stream<String>
    private static void joining() {
        String str = Stream.of ("a", "b", "c")
                .collect(Collectors.joining());
        System.out.println(str); //abc

        str = Stream.of ("a", "b", "c")
                .collect(Collectors.joining(","));  //smart, the last element will not have ,
        System.out.println(str);  //a,b,c
    }

    private static void averaging() {
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
        Double result = ohMy.collect(Collectors.averagingInt(String::length));
        System.out.println(result);
    }
    
    private static void collectingToMaps() {
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

        //what if we prefer Set?
        //groupingBy(classifier, downstreamCollector)
        //downstreamCollector is applied to the values
        ohMy = Stream.of("lions", "tigers", "bears");
        Map<Integer, Set<String>> map2 = ohMy.collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        System.out.println(map2); // {5=[lions, bears], 6=[tigers]}

        //grouping + counting
        ohMy = Stream.of("lions", "tigers", "bears");
        Map<Integer, Long> map4 = ohMy.collect(
                Collectors.groupingBy(
                        String::length,
                        Collectors.counting()
                )
        );
        System.out.println(map4); // {5=2, 6=1}

        //change the type of Map returned
        //groupingBy(classifier, mapFactory, downstreamCollector)
        ohMy = Stream.of("lions", "tigers", "bears");
        Map<Integer, Set<String>> map3 = ohMy.collect(
                Collectors.groupingBy(
                        String::length,
                        TreeMap::new,
                        Collectors.toSet()));
        System.out.println(map3.getClass()); // class java.util.TreeMap
    }

    private static void partitioningBy() {
        //partitioningBy(predicate) -> Map<Boolean,List<T>>
        //With partitioning, there are only two possible groups: true and false.
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
        Map<Boolean, List<String>> map = ohMy.collect(
                Collectors.partitioningBy(e -> e.length() > 5));
        System.out.println(map); // {false=[lions, bears], true=[tigers]}

        //There will always be two keys in the map
        //no elements -> empty list
        ohMy = Stream.of("lions", "tigers", "bears");
        map = ohMy.collect(
                Collectors.partitioningBy(e -> e.length() > 100));
        System.out.println(map); // {false=[lions, tigers, bears], true=[]}

        //partitioningBy(predicate, downstreamCollector)
        ohMy = Stream.of("lions", "tigers", "bears");
        Map<Boolean, Set<String>> map2 = ohMy.collect(
                Collectors.partitioningBy(s -> s.length() > 5, Collectors.toSet())
        );
        System.out.println(map2); // {false=[lions, bears], true=[tigers]}

        //partition + counting
        ohMy = Stream.of("lions", "tigers", "bears");
        Map<Boolean, Long> map3 = ohMy.collect(
                Collectors.partitioningBy(e -> e.length() > 5, Collectors.counting())
        );
        System.out.println(map3); // {false=2, true=1}
    }

    private static void minBy() {
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
        ohMy.collect(Collectors.minBy(Comparator.naturalOrder()))
                .ifPresent(System.out::println);
    }
}
