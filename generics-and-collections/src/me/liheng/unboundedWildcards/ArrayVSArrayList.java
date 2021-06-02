package me.liheng.unboundedWildcards;

public class ArrayVSArrayList {

    public static void main(String[] args) {

        Integer[] numbers = { new Integer(42)};
        Object[] objects = numbers;
        objects[0] = "forty two";  // throws ArrayStoreException

        /*
        Java knows that objects is an Integer[],
        and will throw exception when we try to add a String element.
        This is not the case for ArrayList.
        Due to type erasure, at runtime, ArrayList will allow the String element to be added.
        No runtime exception will be thrown.
        Therefore, Java uses compiler to prevent that from happening.
         */
    }
}
