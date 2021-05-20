package me.liheng.staticNestedClass;

public class Enclosing {

    public int enclosingPrice = 9;

    static class Nested {
        private int price = 5;
        protected static int staticPrice = 8;

        public void accessEnclosingClass() {
            System.out.println(new Enclosing().enclosingPrice);    //Requires instance of enclosing class
        }

        public static void staticAccessEnclosingClass() {
            System.out.println(new Enclosing().enclosingPrice);
        }
    }

    public static void main(String[] args) {

        //If non-static, need to instantiate an Enclosing object first.
        Nested nested = new Nested();

        System.out.println(nested.price);
        System.out.println(Nested.staticPrice);
        nested.accessEnclosingClass();
        Nested.staticAccessEnclosingClass();
        System.out.println(new Enclosing().enclosingPrice);
    }
}
