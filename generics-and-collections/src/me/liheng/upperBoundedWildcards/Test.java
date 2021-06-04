package me.liheng.upperBoundedWildcards;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(58);
        list.add(85);
        System.out.println(total(list));
    }

    public static long total(List<? extends Number> list) {
        long count = 0;
        for (Number number: list)
            count += number.longValue();
        return count;
    }

    private void doesItPrevent() {
        List<? extends Number> list = new ArrayList<Integer>();
        //list.add(new Integer(58)); // DOES NOT COMPILE
        //list.add(new Double(0.58)); // DOES NOT COMPILE
        //list.add("Hello"); // DOES NOT COMPILE
    }
}
