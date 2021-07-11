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

    private void explore() {
        // anonymous inner class way
        Supplier<ArrayList<String>> naiveSupplier = new Supplier<ArrayList<String>>() {
            @Override
            public ArrayList<String> get() {
                return new ArrayList<String>();
            }
        };

        // lambda way
        Supplier<ArrayList<String>> lambdaSupplier = () -> new ArrayList<>();

        // method reference way
        Supplier<ArrayList<String>> referenceSupplier = ArrayList::new;

        // How to read those lines of code?
        // I am creating a supplier that can return a new ArrayList when i call get()
    }
}
