package me.liheng.instanceOf;

public class HeavyAnimal {

    public static void main(String[] args) {

        HeavyAnimal hippo = new Hippo();
        boolean b1 = hippo instanceof Hippo; // true
        boolean b2 = hippo instanceof HeavyAnimal; // true
        boolean b3 = hippo instanceof Elephant; // false

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);

        Hippo hippo2 = new Hippo();
        //boolean b4 = hippo2 instanceof Elephant; // compilation error

        /* Explanation
        b3 has no compilation errors
        because the variable reference is HeavyAnimal, so there could be an Elephant in there.
        This can only be checked at runtime.

        b4 has compilation errors
        because the compiler knows that
        there is no possible way for a Hippo variable reference to be an Elephant.
         */


        boolean b5 = hippo2 instanceof Mother;
        /* Explanation
        Runtime check for interface.
        The reason is that a subclass could implement that interface and the compiler wouldn’t know it.
         */
    }
}


class Hippo extends HeavyAnimal {}

class Elephant extends HeavyAnimal {}

interface Mother {}

class MotherHippo extends Hippo implements Mother {}