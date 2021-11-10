package me.liheng.advancedStream;

import java.util.Optional;

public class ChainingOptionals {

    public static void main(String[] args) {
        Optional<Integer> optional = Optional.of(100);

        //given an Optional<Integer>
        //asked to print the value only if it is a three-digit number

        //without functional programming
        if (optional.isPresent()){
            String intString = optional.get().toString();
            if (intString.length() == 3) {
                System.out.println(intString);
            }
        }

        //functional programming
        optional.map(v -> "" + v)
                .filter(s -> s.length() == 3)
                .ifPresent(System.out::println);
    }
}
