package me.liheng.virtualMethodInvocation;

public class PlayWithAnimal {

    public static void main(String[] args) {

        Animal animal = new Lion();
        animal.careFor(); //Virtual Method Invocation : Animal's careFor() --> Lion's play()
        animal.printName(); //Animal's printName() --> Animal's name

        Lion lion = new Lion();
        lion.printName(); //Animal's printName() --> Animal's name
    }
}
