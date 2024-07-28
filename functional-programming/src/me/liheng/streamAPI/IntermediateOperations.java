package me.liheng.streamAPI;

import java.util.*;
import java.util.stream.Stream;

public class IntermediateOperations {

    public static void main(String[] args) {
        filter();

        System.out.println("\ndistinct:");
        distinct();

        System.out.println("\nskip:");
        skip();

        System.out.println("\nmap:");
        map();

        System.out.println("\nflatMap:");
        flatMap();

        System.out.println("\noneLevelFlatMap:");
        oneLevelFlatMap();

        System.out.println("\nsorted:");
        sorted();

        System.out.println("\npeek:");
        peek();
    }

    //Stream<T> filter(Predicate<? super T> predicate)
    private static void filter() {
        Stream.of("monkey", "gorilla", "bonobo")
                .filter(x -> x.startsWith("m"))
                //Static method format
                .forEach(System.out::println);
    }

    //Stream<T> distinct()
    private static void distinct() {
        Stream<String> s = Stream.of("duck", "duck", "duck", "goose");
        s.distinct()
                .forEach(System.out::println);
    } // duck goose

    private static void skip() {
        Stream<Integer> s = Stream.iterate(1, n -> n+1);
        s.skip(5)
                .limit(2)
                .forEach(System.out::println);
    } // 6 7

    private static void map() {
        Stream<String> s1 = Stream.of("monkey", "gorilla", "bonobo");
        //lambda
        s1.map(e -> e.length())
                .forEach(System.out::println);

        Stream<String> s2 = Stream.of("a", "aa", "aaa");
        //method reference, Instance methods on an instance to be passed in at runtime
        s2.map(String::length)
                .forEach(System.out::println);
    }

    private static void flatMap() {
        List<String> zero = Arrays.asList();
        List<String> one = Arrays.asList("one");
        List<String> two = Arrays.asList("two", "three");

        Stream<List<String>> originalStream = Stream.of(zero, one, two);
        Stream<String> flattenedStream = originalStream.flatMap(l -> l.stream());
        flattenedStream.forEach(System.out::println); //one two three

        //Use method reference
        Stream<List<String>> s = Stream.of(zero, one, two);
        s.flatMap(Collection::stream).forEach(System.out::println); //one two three
    }

    private static void oneLevelFlatMap() {
        List<List<List<String>>> twoLevelList =
                Arrays.asList(
                        Arrays.asList(
                                Arrays.asList("one", "two"),
                                Arrays.asList("three", "four"),
                                Arrays.asList("five", "six")
                        ));
        twoLevelList.stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);
    } // [one, two] [three, four] [five, six]

    private static void sorted() {
        Stream<String> s1 = Stream.of("B", "a", "A", "c");
        s1.sorted().forEach(System.out::println);

        Stream<String> s2 = Stream.of("B", "a", "A", "c");
        s2.sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }

    private static void peek() {
        Stream<String> stream = Stream.of("one", "two", "three", "four");
        List<String> list = stream.filter(s -> s.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        //Filtered value: three
        //Mapped value: THREE
        //Filtered value: four
        //Mapped value: FOUR

        list.forEach(System.out::println);

        System.out.println("Danger of using peek(): may change the state of elements in the stream.");
        List<Integer> numbers = new ArrayList<>();
        List<Character> letters = new ArrayList<>();
        numbers.add(1);
        letters.add('a');
        Stream<List<?>> s = Stream.of(numbers, letters);
        s.peek(l -> l.remove(0))
                .map(List::size)
                .forEach(System.out::println);
    }
}
