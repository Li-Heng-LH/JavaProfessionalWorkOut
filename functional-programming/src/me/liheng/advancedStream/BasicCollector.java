package me.liheng.advancedStream;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicCollector {

    public static void main(String[] args) {
        toCollection();
    }

    //Collector.of
    private static void useCollectorOf() {
        Collector <String, ?, TreeSet<String>> collector = Collector.of(
                TreeSet::new,
                TreeSet::add,
                (left, right) -> { left.addAll(right); return left; }
        );
        TreeSet<String> res = Stream.of("d","c", "b", "a")
                .collect(collector);

        System.out.println(res);
    }

    //Collector.of
    private static void useCollectorOfReversed() {
        Collector<String, ?, TreeSet<String>> collector = Collector.of(
                () -> new TreeSet<>(Comparator.reverseOrder()),
                TreeSet::add,
                (left, right) -> { left.addAll(right); return left; }
        );

        TreeSet<String> res = Stream.of("d","c", "b", "a")
                .collect(collector);

        System.out.println(res);
    }

    private static void toCollection() {
        Set<String> set =
                Stream.of("a", "b", "c")
                .collect(Collectors.toSet());
        System.out.println(set);

        List<String> list = Stream.of("a", "b", "c")
                .collect(Collectors.toList());
        System.out.println(list);

        LinkedList <String> linkedList = Stream.of("a", "b", "c")
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println(linkedList);
    }
}
