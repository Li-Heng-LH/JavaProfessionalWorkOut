package me.liheng.legacyCode;

import java.util.List;

public class LegacyAutoboxing {

    public static void main(String[] args) {

        List numbers = new java.util.ArrayList(); // a raw list
        numbers.add(5);  // Autoboxed to Integer

        // Java doesn’t know that the list contains an Integer
        // It just knows that it is an Object
        //int result = numbers.get(0);  // DOES NOT COMPILE
    }
}
