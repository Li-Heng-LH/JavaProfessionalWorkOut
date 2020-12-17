package me.liheng.virtualMethodInvocation;

abstract class Animal {
    String name = "???";

    public void printName() {
        System.out.println(name);
    }
    public void careFor() {
        play();
    }
    public void play() {
        System.out.println("pet animal");
    }
}


class Lion extends Animal {
    String name = "Leo";

    public void play() {
        System.out.println("toss in meat");
    }
}
