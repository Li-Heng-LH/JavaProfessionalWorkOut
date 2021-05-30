package me.liheng.immutable;

import java.util.Arrays;
import java.util.List;

// Builder Pattern
// In some ways, using the builder pattern is analogous to taking a mutable object and making it read‐only.
public class AnimalBuilder {
    private String species;
    private int age;
    private List<String> favoriteFoods;

    public AnimalBuilder setAge(int age) {  //Note: return AnimalBuilder!
        this.age = age;
        return this;
    }

    public AnimalBuilder setSpecies(String species) {
        this.species = species;
        return this;
    }

    public AnimalBuilder setFavoriteFoods(List<String> favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
        return this;
    }

    public Animal build() {
        return new Animal(species,age,favoriteFoods);
    }



    public static void main(String[] args) {
        // No need to save an instance of builder
        Animal duck = new AnimalBuilder()
                .setAge(4)
                .setFavoriteFoods(Arrays.asList("grass","fish"))
                .setSpecies("duck")
                .build();
    }
}
