package me.liheng.advancedStream;

import java.util.Comparator;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class AdvancedCollector {

    public static void main(String[] args) {
        useCollectorOf();
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
}
