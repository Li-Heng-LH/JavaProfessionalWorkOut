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
