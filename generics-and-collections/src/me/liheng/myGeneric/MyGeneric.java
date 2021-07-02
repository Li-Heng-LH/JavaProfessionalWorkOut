package me.liheng.myGeneric;

import java.util.List;

// About type parameters
public class MyGeneric <T> {

    //perfectly normal use of generics
    static <T> T method1(List<? extends T> list) {
        return list.get(0);
    }

    // Note: <E extends A> is not the return type
    // It says that we want to use E as a type parameter just for this method
    // and that it needs to extend the A class
    // A is the return type
    <E extends A> A method2 (List<? extends E> list) {
        return new A();
    }

    <E extends String> A method4 (List<? extends E> list) {
        return new A();
    }

    // We are using E as a type parameter just for this method
    <E> A method3 (List<? super E> list) {
        return new A();
    }
}

class A {}