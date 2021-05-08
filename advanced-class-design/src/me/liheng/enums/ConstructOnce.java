package me.liheng.enums;

// The first time we ask for any of the enum values, Java constructs all of the enum values.
public enum ConstructOnce {
    ONE(1),
    TWO(2);

    private ConstructOnce(int i) {
        System.out.println("constructing: " + this + "(" + i + ")");
    }

    public static void main(String[] args) {
        ConstructOnce firstCall = ConstructOnce.ONE;    // constructs once
        ConstructOnce secondCall = ConstructOnce.TWO;   // no more construction
    }
}
