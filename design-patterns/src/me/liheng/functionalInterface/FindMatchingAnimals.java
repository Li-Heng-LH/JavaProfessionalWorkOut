package me.liheng.functionalInterface;

import java.util.function.Predicate;

public class FindMatchingAnimals {

    private static void print (Animal animal, Predicate<Animal> trait) { //Note: can specify object type here
        if(trait.test(animal)) {
            System.out.println(animal);
        }
    }

    public static void main(String[] args) {
        print(new Animal("fish", false, true), a -> a.canHop());
        print(new Animal("kangaroo", true, false), a -> a.canHop());
    }
}
