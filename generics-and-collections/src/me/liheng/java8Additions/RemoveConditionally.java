package me.liheng.java8Additions;

import java.util.ArrayList;
import java.util.List;

public class RemoveConditionally {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Magician");
        list.add("Assistant");
        list.add("");
        System.out.println(list); // [Magician, Assistant, ]

        list.removeIf(String::isEmpty);
        System.out.println(list); // [Magician, Assistant]

        list.removeIf(s -> s.startsWith("A"));
        System.out.println(list); // [Magician]

    }
}
