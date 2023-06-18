package me.liheng.optional;

import java.util.Optional;

public class OptionalTwo {

    public static void main(String[] args) {

        //Nested optional
        Optional<Optional<String>> optional = Optional.of(Optional.empty());
        optional.ifPresent(System.out::println);

        //optional.map returns nested optional
        System.out.println(
                Optional.of("1").map(Optional::of)
        );

        //optional.flatMap returns flattened optional
        System.out.println(
                Optional.of("2").flatMap(Optional::of)
        );
    }
}
