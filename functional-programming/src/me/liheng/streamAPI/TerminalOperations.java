package me.liheng.streamAPI;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperations {

    public static void main(String[] args) {
        count();
        minmax();
        find();
        match();
        reduce();
        collect();
    }

    // count() method determines the number of elements in a finite stream
    private static void count() {
        System.out.println(
                Stream.of(1, 2, 3)
                        .count()
        );
    }

    // min() and max() methods allow you to pass a custom comparator and find min/max
    private static void minmax() {
        Stream.of("monkey", "ape", "bonobo")
                .min((s1, s2) -> s1.length() - s2.length())  //returns Optional<String>
                .ifPresent(System.out::println);

        Optional<?> minEmpty = Stream.empty().min((s1, s2) -> 0);
        System.out.println(minEmpty.isPresent());
    }

    // return an element of the stream unless the stream is empty
    // findAny() is useful when you are working with a parallel stream
    // Not reductions, they sometimes return without processing all of the elements
    private static void find() {
        Stream.of(11, 22, 33)
                .findAny()
                .ifPresent(System.out::println);
        Stream.generate(() -> 99)
                .findAny()
                .ifPresent(System.out::println);
        System.out.println(Stream.empty()
                .findAny()
                .isPresent()
        );
    }

    private static void match() {
        System.out.println(
                Stream.of("a", "b", "c")
                .anyMatch(s -> s.equals("c"))
        );
    }

    // combines a stream into a single object
    private static void reduce() {

        // T reduce(T identity, BinaryOperator<T> accumulator)
        System.out.println(
                Stream.of("w", "o", "l", "f")
                        .reduce("", new BinaryOperator<String>() {
                            @Override
                            public String apply(String s, String s2) {
                                return s + s2;
                            }
                        })
        );

        // lambda way
        System.out.println(
                Stream.of("w", "o", "l", "f")
                        .reduce("", (s1, s2) -> s1 + s2)
        );

        // Method reference
        // Instance methods on an instance to be passed in at runtime
        System.out.println(
                Stream.of("w", "o", "l", "f")
                        .reduce("", String::concat)
        );

        System.out.println(
                Stream.of(1, 2, 3, 4)
                        .reduce(1, (a,b) -> a * b)
        );

        System.out.println(
                Stream.of(1, 2, 3, 4)
                        .reduce(0, (a, b) -> a + b)
        );

        System.out.println(
                Stream.of(1, 2, 3, 4)
                        .reduce(0, Integer::min)
        );

        System.out.println(
                Stream.of(1, 2, 3, 4)
                        .reduce(0, Integer::sum)
        );

        // in case of empty Stream
        Stream<Integer> stream = Stream.empty();
        System.out.println(
                stream.reduce(1, (a,b) -> a * b) // 1
        );

        // in case of empty Stream
        Stream<? super Integer> stream2 = Stream.empty();
        System.out.println(
                // stream2.reduce(1, (a,b) -> a * b) // Compilation error
        );

        // in case of 1 element
        System.out.println(
                Stream.of(1)
                        .reduce(0, Integer::sum) // 1
        );

        // Optional<T> reduce(BinaryOperator<T> accumulator)
        //  * If the stream is empty, an empty Optional is returned.
        //  * If the stream has one element, it is returned.
        //  * If the stream has multiple elements, the accumulator is applied to combine them.
        Stream<Integer> stream3 = Stream.empty();
        System.out.println(
                stream3.reduce((a, b) -> a + b)
        );

        System.out.println(
                Stream.of(1).reduce((a, b) -> a + b)
        );

        // <U> U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)
        System.out.println(
                Stream.of(1, 2, 3, 4).reduce(0, Integer::sum, Integer::sum)
        );
    }

    private static void collect() {
        // <R> R collect(Supplier<R> supplier,
        // BiConsumer<R, ? super T> accumulator,
        // BiConsumer<R, R> combiner)
        Stream<String> stream = Stream.of("w", "o", "l", "f");
        StringBuilder word = stream.collect(StringBuilder::new,
                new BiConsumer<StringBuilder, String>() {
                    @Override
                    public void accept(StringBuilder stringBuilder, String s) {
                        stringBuilder.append(s);
                    }
                },
                new BiConsumer<StringBuilder, StringBuilder>() {
                    @Override
                    public void accept(StringBuilder stringBuilder, StringBuilder stringBuilder2) {
                        stringBuilder.append(stringBuilder2);
                    }
                });
        System.out.println(word);

        //lambda way
        StringBuilder word2 = Stream.of("w", "o", "r", "d", "2")
                .collect(StringBuilder::new,
                        (sb, s) -> sb.append(s),
                        (sb1, sb2) -> sb1.append(sb2));
        System.out.println(word2);

        //method reference
        StringBuilder word3 = Stream.of("w", "o", "r", "d", "3")
                .collect(StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append);
        System.out.println(word3);
        
        //Different accumulator and combiner
        TreeSet<String> word4 = Stream.of("w", "o", "r", "d", "4")
                .collect(TreeSet::new,
                        TreeSet::add,
                        TreeSet::addAll);
        System.out.println(word4);

        //common collectors
        //Collectors.toCollection(Supplier): Returns a Collector that accumulates the input elements into a new Collection
        TreeSet<String> word5 = Stream.of("w", "o", "r", "d", "5")
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(word5);

        //Collectors.toSet()
        Set<String> word6 = Stream.of("w", "o", "r", "d", "6")
                .collect(Collectors.toSet());
        //toSet() makes no guarantees as to which implementation of Set you’ll get.
        //It is likely to be a HashSet, but you shouldn’t expect or rely on that.
        System.out.println(word6);
    }
}
