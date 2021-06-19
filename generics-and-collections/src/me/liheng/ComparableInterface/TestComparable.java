package me.liheng.ComparableInterface;

public class TestComparable {

    public static void main(String[] args) {

        Animal animal1 = new Animal(1);
        Animal animal5 = new Animal(5);

        System.out.println(animal1.compareTo(animal5));
        System.out.println(animal5.compareTo(animal1));
    }
}
