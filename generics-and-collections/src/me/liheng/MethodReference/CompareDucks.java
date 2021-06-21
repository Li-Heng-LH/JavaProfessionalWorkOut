package me.liheng.MethodReference;

import me.liheng.ComparatorInterface.Duck;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CompareDucks {

    public static void main(String[] args) {
        new CompareDucks().run();
    }

    public void run() {
        List<Duck> ducks = new ArrayList<>();
        ducks.add(new Duck("A", 2));
        ducks.add(new Duck("B", 1));

        useAnonymousInnerClass(ducks);
        useLambda(ducks);
        intermediate(ducks);
        useMethodReference(ducks);
    }

    private void useAnonymousInnerClass(List<Duck> ducks) {
        System.out.println("Using Anonymous Inner Class");
        ducks.sort(new Comparator<Duck>() {
            @Override
            public int compare(Duck d1, Duck d2) {
                return d1.getWeight() - d2.getWeight();
            }
        });
        System.out.println(ducks);
    }

    private void useLambda(List<Duck> ducks) {
        System.out.println("Using lambdas, sorted by name");
        ducks.sort((d1, d2) -> d1.getName().compareTo(d2.getName()));
        System.out.println(ducks);
    }

    private void intermediate(List<Duck> ducks) {
        System.out.println("Using intermediate approach, sorted by weight");
        ducks.sort((d1, d2) -> DuckHelper.compareByWeight(d1, d2));
        System.out.println(ducks);
    }

    //The :: operator tells Java to pass the parameters automatically into compareByWeight.
    private void useMethodReference(List<Duck> ducks) {
        System.out.println("Using method references, sorted by weight");
        ducks.sort(DuckHelper::compareByWeight);
        System.out.println(ducks);
    }
}
