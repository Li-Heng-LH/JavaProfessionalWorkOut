package me.liheng.ArrayListWildcard;

import java.util.ArrayList;
import java.util.List;

//We need to know what that type will be when instantiating ArrayList
public class Test {

    public static void main(String[] args) {

        //List<String> l  = new ArrayList<? extends String>(); // DOES NOT COMPILE

        //List<?> l2 = new ArrayList<?>(); // DOES NOT COMPILE

        //List<? extends String> l3 = new ArrayList<? extends String>(); // DOES NOT COMPILE

        //List<? super Integer> l4 = new ArrayList<? super Integer>();  // DOES NOT COMPILE

        List<? super Integer> l5 = new ArrayList<>(); //Compiles!

        List<?> l6 = new ArrayList<>(); //Compiles!

        List<? extends Animal> l7 = new ArrayList<>();
        //l7.add(new Dog()); // DOES NOT COMPILE

        List<? super Dog> l8 = new ArrayList<>();
        l8.add(new Dog());
    }
}

class Animal {}
class Dog extends Animal {}