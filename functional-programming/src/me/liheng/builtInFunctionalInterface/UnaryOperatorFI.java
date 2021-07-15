package me.liheng.builtInFunctionalInterface;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryOperatorFI {

    public static void main(String[] args) {
        unaryOperator();
        binaryOperator();
    }

    private static void unaryOperator() {
        // lambda
        UnaryOperator<String> lambdaUnary = s -> s.toUpperCase();

        // method reference
        // Instance methods on an instance to be passed in at runtime
        UnaryOperator<String> referenceUnary = String::toUpperCase;

        System.out.println(referenceUnary.apply("hello"));
    }

    private static void binaryOperator() {
        // lambda
        BinaryOperator<String> lambdaBinary = (s1, s2) -> s1.concat(s2);

        // method reference
        BinaryOperator<String> referenceBinary = String::concat;

        System.out.println(referenceBinary.apply("Hello ", "World"));
    }
}
