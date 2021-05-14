package me.liheng.staticNestedClass;

public class Enclosing {

    static class Nested {
        private int price = 6;
    }

    public static void main(String[] args) {

        //If non-static, need to instantiate an Enclosing object first.
        Nested nested = new Nested();

        System.out.println(nested.price);
    }
}
