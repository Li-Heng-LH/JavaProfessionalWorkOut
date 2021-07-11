package me.liheng.builtInFunctionalInterface;

import java.util.function.Predicate;

public class PredicateFI {

    public static void main(String[] args) {
        predicate();
    }

    private static void predicate() {
        // anonymous inner class
        Predicate<String> anonymousPredicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.isEmpty();
            }
        };

        // lambda
        Predicate<String> lambdaPredicate = s -> s.isEmpty();

        // method reference
        // Instance methods on an instance to be passed in at runtime
        Predicate<String> referencePredicate = String::isEmpty;

        System.out.println(referencePredicate.test(""));
        System.out.println(referencePredicate.test("abc"));
    }
}
