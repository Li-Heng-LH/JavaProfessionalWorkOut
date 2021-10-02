package me.liheng.revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Wildcards {

    public static void main(String[] args) {

        List<Integer> rawList = new ArrayList<>();
        rawList.add(1);
        rawList.add(2);
        rawList.add(3);
        List<? extends Number> list = rawList;
        for (Number i : list) {    //Each element can be treated as a Number
            //no-op
        }
        list.remove(0);      //Can remove
        //list.add(4);             //Cannot add
        printList(list);

        List<Integer> rawList2 = new ArrayList<>();
        rawList2.add(5);
        rawList2.add(6);
        rawList2.add(7);
        List<? super Integer> list2 = rawList2;
        // Cannot treat each element as Integer
        list2.remove(0);    //Can remove
        list2.add(8);             //Can add
        printList(list2);
    }

    private static void printList(List<?> list) {
        for (Object i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
