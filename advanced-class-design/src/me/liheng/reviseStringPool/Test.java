package me.liheng.reviseStringPool;

public class Test {

    public static void main(String[] args) {

        String s1 = "String Pool";
        String s2 = "String Pool";
        String s3 = new String(s1); //created at runtime

        System.out.println("s1 == s2: " + (s1 == s2));
        System.out.println("s1 == s3: " + (s1 == s3));
    }
}
