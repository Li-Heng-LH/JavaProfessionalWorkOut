package me.liheng.streamAPI;

import java.util.*;
import java.util.stream.Stream;

public class StreamSources {

    public static void main(String[] args) {
        Stream<String> empty = Stream.empty();
        System.out.println(empty.count());

        Stream<Integer> singleElement = Stream.of(1);
        System.out.println(singleElement.count());

        // The method signature uses varargs
        Stream<Integer> fromArray = Stream.of(1, 2, 3);
        System.out.println(fromArray.count());

        // convert a list to a stream
        List<String> list = Arrays.asList("a", "b", "c", "d");
        Stream<String> fromList = list.stream();
        System.out.println(fromList.count());

        // creates a stream that is allowed to process elements in parallel
        // Just keep in mind that it isn’t worth working in parallel for small streams.
        // There is an overhead cost in coordinating the work.
        Stream<String> fromListParallel = list.parallelStream();
        System.out.println(fromListParallel.count());

        infiniteStream();

        collectionToStream();

        mapToStream();

    }

    private static void infiniteStream() {

        // Returns an infinite sequential unordered stream
        // suitable for generating constant streams, streams of random elements, etc
        Stream<Double> randoms = Stream.generate(Math::random);
        // System.out.println(randoms.count()); //This will run infinitely
        // randoms.forEach(System.out::println); //This will run infinitely

        Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);
    }

    private static void collectionToStream() {
        Set<Integer> integers = new HashSet<>();
        integers.add(1);
        integers.add(2);
        System.out.println(integers.stream().count());
    }

    private static void mapToStream() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");

        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        entries.stream()
                .forEach(System.out::println);

        Set<Integer> keySet = map.keySet();
        keySet.stream()
                .forEach(System.out::println);
    }
}
