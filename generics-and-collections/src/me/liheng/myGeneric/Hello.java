package me.liheng.myGeneric;

import java.util.List;

public class Hello <T> {
    T t;

    public Hello(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return t.toString();   //treated as Object now, can use toString
    }

    //Type parameter with extends
    public <E extends List> void test(E list) {
        System.out.println(list.size());   //E can use List's methods
    }

    public static void main(String[] args) {
        System.out.println(new Hello<String>("hello"));
        System.out.println(new Hello<>("ni hao")); //can omit type parameter as T is inferred to be String

        System.out.println(new Hello("world"));    //Legacy code before generics, T is treated as Object, can use toString,
        // like the following:
        Object obj = "tt";
        System.out.println(obj);
    }
}
