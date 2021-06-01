package me.liheng.unboundedWildcards;

import java.util.ArrayList;
import java.util.List;

public class CannotAssign {

    public static void main(String[] args) {
        List<String> keywords = new ArrayList<>();
        keywords.add("java");
        //printList(keywords); //DOES NOT COMPILE

        // List<String> cannot be assigned to List<Object>

    }

    private static void printList(List<Object> list) {
        for (Object x: list)
            System.out.println(x);
    }


    // List<String> cannot be assigned to List<Object>
    private void whyIsThisSo() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(42);
        //Imagine if Java allows this: List<Object> objects = numbers;
        //Then we can then do this: objects.add("forty two");
    }
}
