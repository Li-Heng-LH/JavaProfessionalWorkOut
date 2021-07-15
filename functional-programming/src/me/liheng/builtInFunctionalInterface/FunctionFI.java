package me.liheng.builtInFunctionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionFI {

    public static void main(String[] args) {
        function();
        biFunction();
    }

    private static void function() {
        // anonymous inner class
        Function<String, Integer> anonymousFunction = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };

        // lambda
        Function<String, Integer> lambdaFucntion = s -> s.length();

        // method reference
        // Instance methods on an instance to be passed in at runtime
        Function<String, Integer> referenceFunction = String::length;

        System.out.println(referenceFunction.apply("Hello"));
    }

    private static void biFunction() {
        // lambda
        BiFunction<String, String, String> lambdaBiFunction = (s1, s2) -> s1.concat(s2);

        // method reference
        // Instance methods on an instance to be passed in at runtime
        BiFunction<String, String, String> referenceBiFunction = String::concat;

        System.out.println(referenceBiFunction.apply("Hello ", "World"));
    }
}
