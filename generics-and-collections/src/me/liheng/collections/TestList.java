package me.liheng.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestList {

    public static void main(String[] args) {

        //RemoveConditionally iterator
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        list.add("Here");
        list.add("I");
        list.add("am");

        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
