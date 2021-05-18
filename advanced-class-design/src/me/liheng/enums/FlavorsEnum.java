package me.liheng.enums;

public class FlavorsEnum {

    // Member inner enum
    enum Flavors {
        VANILLA, CHOCOLATE, STRAWBERRY
    }

    public static void main(String[] args) {
        System.out.println(Flavors.CHOCOLATE.ordinal());  //1
    }
}
