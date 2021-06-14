package me.liheng.genericMethod;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Crate<T> {

    public static <T> Crate<T> ship(T t) {     //Cannot derive generic formal type parameter from instance
        System.out.println("Shipping " + t);
        return new Crate<T>();
    }

    public Crate<T> prepare(T t) {             //Can derive generic formal type parameter from instance
        System.out.println("Preparing " + t);
        return new Crate<T>();
    }

    public <T> List<T> fromArrayToList(T[] a) {
        return Arrays.stream(a).collect(Collectors.toList());
    }
}

class Util {
    public <T> void test(T something) {} // Here, the type parameter is needed.

    // We can see the use of type parameter here
    // Yes, type parameter can use wildcards
    public <T extends List> T test2 (T something) { // Here, the type parameter is needed.
        something.size();
        return something;
    }
}