package me.liheng.optional;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

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
        Optional<Double> opt = average();  // Optional with null

        // orElse(T other) : Returns other
        System.out.println(opt.orElse(0.0));
        System.out.println(opt.orElse(Double.NaN));
        System.out.println(opt.orElse(Math.random()));

        // orElseGet(Supplier s) : Returns result of calling Supplier
        // anonymous class
        System.out.println(opt.orElseGet(new Supplier<Double>() {
            @Override
            public Double get() {
                return Math.random();
            }
        }));
        // lambda
        System.out.println(opt.orElseGet(() -> Math.random()));
        // method reference
        System.out.println(opt.orElseGet(Math::random));

        // orElseThrow(Supplier s) : Throws exception created by calling Supplier
        // lambda
        System.out.println(opt.orElseThrow(() -> new IllegalStateException()));
        // method reference
        System.out.println(opt.orElseThrow(IllegalAccessError::new));
    }
}
