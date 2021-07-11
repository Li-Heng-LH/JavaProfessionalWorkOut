package me.liheng.builtInFunctionalInterface;

import java.util.function.Consumer;

public class ConsumerFI {

    public static void main(String[] args) {

        // anonymous inner class way
        Consumer<String> naiveConsumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        // lambda way
        Consumer<String> lambdaConsumer = s -> System.out.println(s);
        // Note: it is ok if -> side returns void;

        // method reference way
        Consumer<String> referenceConsumer = System.out::println;

        naiveConsumer.accept("Hello");
        lambdaConsumer.accept("World");
        referenceConsumer.accept("Yay");

        // I am creating a consumer that accepts a String and process it.
    }
}
