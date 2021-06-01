package me.liheng.legacyCode;

import java.util.ArrayList;
import java.util.List;

//This is the problem that generics are supposed to solve.
public class LegacyDragons {

    public static void main(String[] args) {
        List unicorns = new ArrayList();
        unicorns.add(new Unicorn());

        //List of raw types is passed in
        //Due to type erasure, Java doesn’t know this is a problem until runtime
        //when it attempts to cast a Unicorn to a Dragon
        printDragons(unicorns);
    }

    private static void printDragons(List<Dragon> dragons) {
        for (Dragon dragon : dragons) {
            System.out.println(dragon);
        }
    }
}


class Dragon {}
class Unicorn {}