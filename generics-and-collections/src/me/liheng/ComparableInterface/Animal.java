package me.liheng.ComparableInterface;

public class Animal implements Comparable<Animal> {
    private final int id;

    public Animal(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Animal a) {
        return id - a.id;
    }
}



// We can see the advantage of using generics here.
// Note: Comparable without generics
class AnimalRaw implements Comparable {

    // Here we need to cast
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}