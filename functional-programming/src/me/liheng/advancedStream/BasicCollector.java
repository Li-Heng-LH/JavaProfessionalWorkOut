package me.liheng.advancedStream;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicCollector {

    public static void main(String[] args) {
        toCollection();
        self_implemented_combiner();
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

    private static void self_implemented_combiner() {
        List<Integer> list = Stream.of(1, 2, 3, 4, 5, 6)
                .collect(ArrayList::new,  //Supplier
                        List::add,        //accumulator
                        (l1, l2) -> l2.forEach(l1::add));  //combiner
        System.out.println(list);
    }
}
