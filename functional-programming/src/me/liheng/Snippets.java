package me.liheng;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Snippets {

    private static final Supplier<List<Integer>> integersSupplier =
            () -> IntStream.rangeClosed(1, 10)
                    .boxed()
                    .collect(Collectors.toList());

    public static void main(String[] args) {
        new Snippets().run();
    }
    private void run() {
        System.out.println(filterList(integersSupplier.get()));
        filterList2(integersSupplier.get());
        System.out.println(reduceString());
        System.out.println(reduceIntegers(integersSupplier.get()));
        streamSupplier();
        System.out.println(toMapCollector());
    }

    private List<Integer> filterList(List<Integer> integers){
        return integers.stream()
                .filter(i -> i > 5)
                .collect(Collectors.toList());
    }

    private void filterList2(List<Integer> integers) {
        integers.removeIf(i -> i <= 5);
        System.out.println(integers);
    }

    private String reduceString() {
        return Stream.of("a", "b", "c", "d")
                .reduce("", String::concat); //Instance method reference
    }

    private int reduceIntegers(List<Integer> integers) {
        return integers.stream()
                .reduce(0, Integer::sum);
    }

    private void streamSupplier() {
        Supplier<Stream<Integer>> integersStreamSupplier =
                () -> IntStream.rangeClosed(1, 10).boxed();
        System.out.println(integersStreamSupplier.get().count());
        System.out.println(integersStreamSupplier.get().count());
    }

    private Map<Integer, String> toMapCollector() {
        return Stream.of("a", "ab", "ab", "cd", "efg")
                .collect(Collectors.toMap(String::length,
                        s -> s,
                        (a, b) -> a + ", " + b  //BinaryOperator mergeFunction
                ));
    }
}
