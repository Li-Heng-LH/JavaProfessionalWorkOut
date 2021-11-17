package me.liheng.revision;

import java.util.*;

public class Compares {

    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>(Comparator.reverseOrder());
        treeSet.add("a");
        treeSet.add("d");
        treeSet.add("c");
        treeSet.add("b");
        System.out.println(treeSet);

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("d");
        list.add("c");
        list.add("b");

        Collections.sort(list);
        System.out.println(list);

        Collections.sort(list, (a, b) -> a.compareTo(b));
        System.out.println(list);

        Collections.sort(list, (a, b) -> b.compareTo(a));
        System.out.println(list);

        Collections.sort(list, Comparator.reverseOrder());
        System.out.println(list);
    }
}
