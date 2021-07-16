package me.liheng.optional;

import java.util.Optional;

public class OptionalWalkThrough {

    public static void main(String[] args) {
        System.out.println(average(90, 100));
        System.out.println(average());

        Optional<Double> opt = average(90, 100);
        if (opt.isPresent()) {
            System.out.println(opt.get());
        }

        String value = "string";
        //Returns an Optional describing the specified value if non-null, otherwise returns empty Optional
        Optional<String> o = Optional.ofNullable(value);
        System.out.println(o);
    }

    private static Optional<Double> average(int... scores) {
        if (scores.length == 0) {
            return Optional.empty();
        }
        int sum = 0;
        for (int score: scores) sum += score;
        return Optional.of((double) sum / scores.length);
    }
}
