package me.liheng.java8Additions;

import java.util.Arrays;
import java.util.List;

public class UpdatingAll {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3);
        list.replaceAll(integer -> integer * 2);
        System.out.println(list);

        List<String> listOfStr = Arrays.asList("a b c", "A B C", "   ");
        listOfStr.replaceAll(s -> s.replaceAll(" ", ""));
        System.out.println(listOfStr);

        List<String> listOfStr2 = Arrays.asList(" abc ", "A B C", "   ");
        listOfStr2.replaceAll(String::trim);
        System.out.println(listOfStr2);
    }
}
