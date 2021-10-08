package me.liheng.revision;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class MethodReferences {

    public static void main(String[] args) {
        new MethodReferences().run();
    }

    private void run() {
        instanceMethodOnKnownInstance();
        System.out.println();
        instanceMethodOnRuntimeInstance();
    }

    private void instanceMethodOnKnownInstance() {
        List<String> list = Arrays.asList("Dog", "Cat");
        Set<String> mammals = new HashSet<>(list); //known instance: mammals
        Stream<String> s1 = Stream.of("Dog", "Cat", "Fish", "Bird", "Chicken");
        s1.filter(mammals::contains) //chek if mammals set contain each element
                .forEach(System.out::println);

        Stream<String> s2 = Stream.of("Dog", "Cat", "Fish", "Bird", "Chicken");
        s2.map(mammals::contains)
                .forEach(System.out::println);
    }

    private void instanceMethodOnRuntimeInstance() {
        Stream<String> s = Stream.of("Dog", "Cat", "Fish", "", "Bird", "Chicken");
        s.filter(String::isEmpty)
                .forEach(System.out::println);

        Stream<String> s2 = Stream.of("Dog", "Cat", "Fish", "Bird", "Chicken");
        s2.map(String::length)
                .forEach(System.out::println);
    }

}
