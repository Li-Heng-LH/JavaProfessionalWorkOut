package me.liheng.builtInFunctionalInterface;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Supplier;

public class SupplierFI {

    public static void main(String[] args) {

        // Static method reference
        Supplier<LocalDate> s1 = () -> LocalDate.now();
        Supplier<LocalDate> s2 = LocalDate::now;
        System.out.println(s1.get());
        System.out.println(s2.get());

        // Constructor method reference
        Supplier<ArrayList<String>> s3 = () -> new ArrayList<>();
        Supplier<ArrayList<String>> s4 = ArrayList::new;

        ArrayList<String> list = s4.get();
        list.add("Hello");

        System.out.println(s3.get());
        System.out.println(s4.get());
        System.out.println(list);
    }
}
