package me.liheng.revision;

public class autoboxing {

    public static void main(String[] args) {

        System.out.println(new Integer(0) == new Integer(0)); //false, compares addresses
        System.out.println(new Integer(0) < new Integer(1));  //true, compares values
        System.out.println(new Integer(1) + new Integer(2));  //true, manipulates values
    }
}
