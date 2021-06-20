package me.liheng.collections;

import java.util.Set;
import java.util.TreeSet;

public class UseTreeSet {

    static class Person{
        int id;
        String name;
        int age;

        public Person(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) {
        Person a = new Person(1, "A", 1);
        Person b = new Person(2, "B", 3);
        Person c = new Person(3, "C", 2);


        Set<Person> persons = new TreeSet<>();
        // throws an exception: cannot be cast to java.lang.Comparable
        // persons.add(a);

        Set<Person> personsByAge = new TreeSet<>((p1, p2) -> p1.age - p2.age);
        personsByAge.add(a);
        personsByAge.add(b);
        personsByAge.add(c);
        System.out.println(personsByAge);

        Set<Person> personsByName = new TreeSet<>((p1, p2) -> p1.name.compareTo(p2.name));
        personsByName.add(a);
        personsByName.add(b);
        personsByName.add(c);
        System.out.println(personsByName);
    }
}
