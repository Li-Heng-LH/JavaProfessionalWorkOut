package me.liheng.testNull;

public class TestNull {

    public static void main(String[] args) {

        //instanceof
        System.out.println(null instanceof Object); //false
        //System.out.println(new Object() instanceof null); //Error
        System.out.println(null instanceof TestNull); //false
        //System.out.println(new TestNull() instanceof null); //Error

        //==
        System.out.println(null == null); //true
        System.out.println(new Object() == null); //false
        System.out.println(new TestNull() == null); //false

        //equals
        System.out.println(new Object().equals(null)); //false
        System.out.println(new TestNull().equals(null)); //false
        //System.out.println(null.equals(null)); //error
    }
}
