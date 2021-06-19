package me.liheng.collections;

import java.util.*;

// Testing which data structures allow nulls
public class TestNull {

    public static void main(String[] args) {
        ArrayListWithNull();
        ArrayDequeWithNull();
        HashSetWithNull();
        TreeSetWithNull();
    }

    private static void ArrayListWithNull() {
        List<String> list = new ArrayList<>();
        list.add(null);
        System.out.println(list);
    }

    private static void ArrayDequeWithNull() {
        ArrayDeque<String> deque = new ArrayDeque<>();
        //deque.add(null);    // Will throw NullPointerException
    }

    private static void HashSetWithNull() {
        Set<String> set = new HashSet<>();
        set.add(null);
        System.out.println(set);
    }

    private static void TreeSetWithNull() {
        Set<String> set = new TreeSet<>();
        //set.add(null);    // Will throw NullPointerException
    }
}
