package me.liheng.revision;

public interface TestInterface {

    public static final int i = 9;  //By default instance is public static final.

    static int getInt() {
        return i;
    }
}

class Test {
    public static void main(String[] args) {

        System.out.println(TestInterface.getInt());  //Usage is the same as class static methods
    }
}
