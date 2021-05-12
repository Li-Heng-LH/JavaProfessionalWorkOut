package me.liheng.memberInnerClass;

// Member Inner Class
// a complicated way to print “Hi” three times
public class Outer {
    private String greeting = "Hi";

    protected class Inner {
        private int repeat = 3;
        public void go() {
            for (int i = 0; i < repeat; i++) {
                System.out.println(greeting);
            }
        }
    }

    public void callInner() {
        Inner inner = new Inner();
        inner.go();
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.callInner();
    }
}

class Test {
    public static void main(String[] args) {
        Outer outer = new Outer();              // Need to instantiate Outer first
        Outer.Inner inner = outer.new Inner();  // create the inner class
        inner.go();

        //We can’t just call new Inner() because Java won’t know with which instance of Outer it is associated.
    }
}
