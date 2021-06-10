package me.liheng.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TestSet {

    public static void main(String[] args) {
        testHashSet();
        testTreeSet();
    }

    private static void testHashSet() {
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(88);
        hashSet.add(8);
        hashSet.add(58);
        hashSet.add(5);
        printSetUsingLoop(hashSet);
        printSetUsingIterator(hashSet);

    }

    private static void testTreeSet() {
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(88);
        treeSet.add(8);
        treeSet.add(58);
        treeSet.add(5);
        printSetUsingLoop(treeSet);
        printSetUsingIterator(treeSet);
    }

    private static void printSetUsingLoop(Set<Integer> set) {
        for (Integer i : set) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void printSetUsingIterator(Set<Integer> set) {
        Iterator<Integer> iter = set.iterator();
        while(iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();
    }
}
