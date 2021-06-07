package me.liheng.upperBoundedWildcards;

import java.util.ArrayList;
import java.util.List;

// Regarding top hierarchy parent class
// Yes, List<Animal> is a List<? extends Animal>
public class TestTopHierarchy {

    public static void main(String[] args) {
        List<Dog> dogList = new ArrayList<>();
        takeInAnimal(dogList);

        List<Animal> animalList = new ArrayList<>();
        takeInAnimal(animalList);
    }

    private static void takeInAnimal(List<? extends Animal> list) {
        //list.add(new Animal()); //Oh, does not compile
        //because later we may need certain methods of Dog, Animal may not have.

        //list.add(new Dog()); //does not compile
        //because the list can contain Cats.
    }
}

class Animal {}
class Dog extends Animal {}