package me.liheng.optional;

import java.util.Optional;
import java.util.function.Consumer;

public class OptionalWalkThrough {

    public static void main(String[] args) {

        // static methods
        System.out.println(average(90, 100));
        System.out.println(average());

        String value = "string";
        //Returns an Optional describing the specified value if non-null, otherwise returns empty Optional
        Optional<String> o = Optional.ofNullable(value);
        System.out.println(o);

        // instance methods
        presentMethods();
        orElseMethods();
    }

    private static Optional<Double> average(int... scores) {
        if (scores.length == 0) {
            return Optional.empty();
        }
        int sum = 0;
        for (int score: scores) sum += score;
        return Optional.of((double) sum / scores.length);
    }

    private static void presentMethods() {
        Optional<Double> opt = average(90, 100);

        // Naive way
        if (opt.isPresent()) {
            System.out.println(opt.get());
        }

        // anonymous class way
        opt.ifPresent(new Consumer<Double>() {
            @Override
            public void accept(Double d) {
                System.out.println(d);
            }
        });

        // lambda way
        opt.ifPresent(d -> System.out.println(d));

        // methods reference
        opt.ifPresent(System.out::println);
    }

    private static void orElseMethods() {
    }
}
