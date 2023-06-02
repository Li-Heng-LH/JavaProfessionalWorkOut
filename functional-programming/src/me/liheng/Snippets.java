package me.liheng;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
}
