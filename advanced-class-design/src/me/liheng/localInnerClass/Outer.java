package me.liheng.localInnerClass;

public class Outer {
    private int length = 5;
    private int test = 0;

    public void calculate() {
        final int width = 20; //has to be effectively final
        String message = "Area is ";

        class Inner {
            private int length = Outer.this.length; //Need Outer.this to prevent self reference

            public void multiply() {
                System.out.println(test);           //Can directly access field of enclosing class, even private
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
