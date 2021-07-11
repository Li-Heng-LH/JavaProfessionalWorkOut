package me.liheng.builtInFunctionalInterface;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class BiConsumerFI {

    public static void main(String[] args) {

        // Note: Important: map here is effectively final
        Map<String, Integer> map = new HashMap<>();

        // map = new HashMap<>();  //if this is uncommented, map cannot be used in AIC and lambda

        // anonymous inner class way
        BiConsumer<String, Integer> naiveBiConsumer = new BiConsumer<String, Integer>() {
            @Override
            public void accept(String s, Integer integer) {
                map.put(s, integer);
            }
        };

        // lambda way
        BiConsumer<String, Integer> lambdaBiConsumer = (s, i) -> map.put(s, i);

        // method reference way
        // Instance methods on a particular instance
        BiConsumer<String, Integer> referenceBiConsumer = map::put;
        // Can use non-final local variable in method references though

        referenceBiConsumer.accept("One", 1);
        System.out.println(map);
    }
}
