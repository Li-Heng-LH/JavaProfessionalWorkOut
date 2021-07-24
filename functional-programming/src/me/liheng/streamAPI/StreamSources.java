package me.liheng.streamAPI;

import java.util.stream.Stream;

public class StreamSources {

    public static void main(String[] args) {
        Stream<String> empty = Stream.empty();
        System.out.println(empty.count());
    }
}
