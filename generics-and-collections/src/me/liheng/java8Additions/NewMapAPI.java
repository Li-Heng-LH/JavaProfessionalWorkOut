package me.liheng.java8Additions;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class NewMapAPI {

    public static void main(String[] args) {
        new NewMapAPI().run();
    }

    private void run() {
        putIfAbsent();
        merge();
    }

    private void putIfAbsent() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", null);

        //this is allowed, no exception, because no mapper function
        map.putIfAbsent("A", null);
    }

    private void merge() {
        Map<String, Integer> map = new HashMap<>();
        BiFunction<Integer, Integer, Integer> mapper = Math::max;
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", null);

        map.merge("A", 100, mapper);
        System.out.println(map);

        //value passed in cannot be null, because of the mapper function
        //map.merge("A", null, mapper);  //throws NullPointerException, because of the mapper function

        map.merge("B", 1, mapper);
        System.out.println(map);

        map.merge("C", 3, mapper);
        System.out.println(map);

        map.merge("D", 4, mapper);
        System.out.println(map);

        // this is allowed
        map.merge(null, 0, mapper);
        System.out.println(map);


        // when the mapping function is called and returns null
        // the key is removed from the map
        BiFunction<Integer, Integer, Integer> mapToNull = (v1, v2) -> null;
        map.merge("D", 99, mapToNull);
        System.out.println(map);

        map.merge("E", 99, mapToNull);
        System.out.println(map); //E:99 is added because mapToNull is not called
    }
}
