package me.liheng.ComparatorInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompareDuck {

    public static void main(String[] args) {

        //This is an anonymous inner class
        //We could have named it in another class eg: ByWeightComparator
        //Here we are defining and instantiating at the same time
        Comparator<Duck> byWeight = new Comparator<Duck>() {
            @Override
            public int compare(Duck d1, Duck d2) {
                return d1.getWeight() - d2.getWeight();
            }
        };

        Comparator<Duck> byWeightLambda = (d1, d2) -> d1.getWeight() - d2.getWeight();

        List<Duck> ducks = new ArrayList<>();
        ducks.add(new Duck("A", 17));
        ducks.add(new Duck("B", 9));
        ducks.add(new Duck("C", 10));
        Collections.sort(ducks, byWeight);
        System.out.println(ducks);                 //B, C, A

        Collections.sort(ducks, byWeightLambda);
        System.out.println(ducks);                 //B, C, A

        Collections.sort(ducks, (d1, d2) -> d1.getName().compareTo(d2.getName()));
        System.out.println(ducks);                 //A, B, C
    }
}
