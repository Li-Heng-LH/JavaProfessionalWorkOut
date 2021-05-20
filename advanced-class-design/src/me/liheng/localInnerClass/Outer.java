package me.liheng.localInnerClass;

public class Outer {
    private int length = 5;

    public void calculate() {
        final int width = 20; //has to be effectively final
        String message = "Area is ";

        class Inner{
            private int length = Outer.this.length; //Can access field of enclosing class

            public void multiply() {
                System.out.print(message);          //Can access effectively final local variable
                System.out.println(length * width); //Can access effectively final local variable
            }
        }

        Inner inner = new Inner();
        inner.multiply();
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.calculate();
    }
}
