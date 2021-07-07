package me.liheng.java8Additions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(2, 4, 1, 3, 5);
        Collections.sort(list, (o1, o2) -> o2 - o1);
        System.out.println(list);  //[5, 4, 3, 2, 1]

        // sorted with same comparator can alr
        // does NOT mean must be "1,2,3,4,5"
        for (int i = 5; i >= 1; i--)
            System.out.println(Collections.binarySearch(list, i, (o1, o2) -> o2 - o1));
    }
}
