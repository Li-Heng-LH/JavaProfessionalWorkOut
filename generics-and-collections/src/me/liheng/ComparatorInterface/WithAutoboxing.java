package me.liheng.ComparatorInterface;

import java.util.Comparator;

public class WithAutoboxing {

    public static void main(String[] args) {

        Comparator<Integer> comparator = (o1, o2) -> o1 - o2; // fine
        // o1 and o2 are both Integers and there is no warnings.
        // else, there is no other way.
    }

    private void testAutoboxing() {
        //Both can compile, just have warnings
        Integer integer = new Integer(2) - new Integer(1);
        int i = new Integer(2) * new Integer(1);

        Integer integer1 = 2 - 1;  // Correct use of autoboxing
        int i1 = new Integer(1);  // can compile, just has warnings

        // Observations about autoboxing:
        // 1. int can be assigned to Integer
        // 2. Integer can be assigned into int
        // 3. Integer can do arithmetic with Integer
    }
}
