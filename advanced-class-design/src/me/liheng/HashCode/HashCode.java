package me.liheng.HashCode;

public class HashCode {

    public static void main(String[] args) {
        System.out.println(new HashCode().toString());

        System.out.println("HashCode 1 hashcode: " + new HashCode().hashCode());
        System.out.println("HashCode 2 hashcode: " + new HashCode().hashCode());
        System.out.println("Object 1 hashcode: " + new Object().hashCode());
        System.out.println("Object 2 hashcode: " + new Object().hashCode());
    }

    //Error: cannot use long
    /*
    @Override
    public long hashCode() { //Error
        return 0;
    }
    */
}
