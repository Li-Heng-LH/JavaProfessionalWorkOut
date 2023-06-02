package me.liheng.builtInFunctionalInterface;

import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class SupplierFI2 {

    public static void main(String[] args) {
        new SupplierFI2().run();
    }

    private void run() {
        Supplier<Predicate<Integer>> predicateSupplier = () -> i -> i > 5;
        IntStream.rangeClosed(1, 10)
                .boxed()
                .filter(predicateSupplier.get())
                .forEach(System.out::println);
    }
}
