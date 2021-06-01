package me.liheng.unboundedWildcards;

import java.util.ArrayList;
import java.util.List;

public class Whatever {

    public static void main(String[] args) {
        List<String> keywords = new ArrayList<>();
        keywords.add("java");
        printList(keywords);
    }

    private static void printList(List<?> list) {
        for (Object x: list) System.out.println(x);  //Note the Object here
    }
}
