package me.liheng.lowerBoundedWildcards;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Original");
        printList(list);

        List<Animal> animals = new ArrayList<>();
        testTopHierarchy(animals);
    }

    private static void printList(List<? super String> list) {
        list.add("Added");
        System.out.println(list);
    }

    private static void testTopHierarchy(List <? super Dog> list) {
        list.add(new Dog()); //yes, where parent is expected, child can be used.

        //list.add(new Animal()); // Does NOT compile
        //lets say this is a list of mammals,
        //later we want to use mammals' methods, but Animal does not have.
        //i.e, possible issues with hierarchy levels.
    }
}

class Animal {}
class Dog extends Animal {}