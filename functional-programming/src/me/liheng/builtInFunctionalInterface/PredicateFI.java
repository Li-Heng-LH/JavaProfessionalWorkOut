package me.liheng.builtInFunctionalInterface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateFI {

    public static void main(String[] args) {
        predicate();
        biPredicate();
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

    private static void biPredicate() {

        // anonymous inner class
        BiPredicate<String, String> anonymousBP = new BiPredicate<String, String>() {
            @Override
            public boolean test(String s, String prefix) {
                return s.startsWith(prefix);
            }
        };

        // lambda
        BiPredicate<String, String> lambdaBP = (s, prefix) -> s.startsWith(prefix);

        // method reference
        // combines two techniques
        BiPredicate<String, String> referenceBP = String::startsWith;

        System.out.println(referenceBP.test("abc", "a"));
    }
}
