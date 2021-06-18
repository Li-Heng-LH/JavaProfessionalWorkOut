package me.liheng.collections;

import java.util.Map;
import java.util.TreeMap;

public class TestMap {

    public static void main(String[] args) {

        Map<String, String> map = new TreeMap<>();
        map.put("koala", "bamboo");
        map.put("lion", "meat");
        map.put("giraffe", "leaf");


        // the keySet returned from TreeMap is sorted
        for (String key: map.keySet()) {
            System.out.print(key + ",");  // giraffe,koala,lion,
        }

        System.out.println();

        // the values will be sorted according to te sorted keys as well.
        for (String value: map.values()) {
            System.out.print(value + ","); // leaf,bamboo,meat,
        }
    }
}
