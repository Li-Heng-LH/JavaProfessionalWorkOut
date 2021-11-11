package me.liheng.advancedStream;

import java.io.IOException;
import java.util.List;
import java.util.function.Supplier;

public class ExceptionCaseStudy {

    private static List<String> create() throws IOException {
        throw new IOException();
    }

    public static void main(String[] args) {
        try {
            System.out.println(ExceptionCaseStudy.create().stream().count());
        } catch (IOException e) {
            System.out.println(e);
        }


        // Supplier<List<String>> s = ExceptionCaseStudy::create;
        // DOES NOT COMPILE
        // functional interfaces do not declare checked exceptions

        // Way 1
        // catch the checked exception
        // and turn it into an unchecked exception (runtime)
        Supplier<List<String>> s = () -> {
            try {
                return ExceptionCaseStudy.create();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };

        // Way 2
        // Use Wrapper method
        Supplier<List<String>> s2 = ExceptionCaseStudy::createSafe;
    }

    // Wrapper method
    // catch the checked exception
    // and turn it into an unchecked exception (runtime)
    private static List<String> createSafe() {
        try {
            return ExceptionCaseStudy.create();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
