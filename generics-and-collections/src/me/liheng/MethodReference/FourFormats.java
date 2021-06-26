package me.liheng.MethodReference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FourFormats {

    public static void main(String[] args) {
        new FourFormats().run();
    }

    private void run() {
        staticMethodFormat();
        instanceMethodOnInstance();
        instanceMethodOnRuntimeInstance();
        constructorFormat();
    }

    private void staticMethodFormat() {
        Consumer<List<Integer>> consumer = l -> Collections.sort(l);
        Consumer<List<Integer>> consumer2 = Collections::sort;

        List<Integer> list = Arrays.asList(4, 2, 3, 1);
        consumer2.accept(list);

        System.out.println(list);
    }

    private void instanceMethodOnInstance() {
        String str = "abc";
        Predicate<String> predicate = s -> str.startsWith(s);
        Predicate<String> predicate2 = str::startsWith;

        System.out.println(predicate2.test("a"));
    }

    private void instanceMethodOnRuntimeInstance() {
        Predicate<String> predicate = s -> s.isEmpty();
        Predicate<String> predicate2 = String::isEmpty;
        // It looks like a static method, but it isn’t
        // Java knows that isEmpty is an instance method that does not take any parameters
        // Java uses the parameter supplied at runtime as the instance on which the method is called

        System.out.println(predicate2.test(""));
        System.out.println(predicate2.test("abc"));
    }

    private void constructorFormat() {
        Supplier<List<Integer>> supplier = () -> new ArrayList<>();
        Supplier<List<Integer>> supplier2 = ArrayList::new;

        List<Integer> list = supplier2.get();
        list.add(100);
        System.out.println(list);
    }
}
