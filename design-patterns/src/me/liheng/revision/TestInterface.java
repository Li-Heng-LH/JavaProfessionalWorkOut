package me.liheng.revision;

public abstract interface TestInterface {  //By default it is declared abstract

    public static final int i = 9;  //By default instance is public static final.

    public abstract void test(); //By default methods are public abstract.

    static int getInt() {
        return i;
    }
}

class Test {
    public static void main(String[] args) {

        System.out.println(TestInterface.getInt());  //Usage is the same as class static methods
    }
}
