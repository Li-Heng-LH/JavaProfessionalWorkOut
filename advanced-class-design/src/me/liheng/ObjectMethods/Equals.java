package me.liheng.ObjectMethods;

public class Equals {

    public static void main(String[] args) {
        String s1 = new String("lion");
        String s2 = new String("lion");
        System.out.println(s1.equals(s2)); // true: String does have an overriden equals() method

        StringBuilder sb1 = new StringBuilder("lion");
        StringBuilder sb2 = new StringBuilder("lion");
        System.out.println(sb1.equals(sb2)); // false: StringBuilder uses the implementation of equals() provided by Object


    }
}

class Lion {
    private int idNumber;
    private int age;
    private String name;
    public Lion(int idNumber, int age, String name) {
        this.idNumber = idNumber;
        this.age = age;
        this.name = name;
    }
    @Override
    public boolean equals(Object obj) {
        if ( !(obj instanceof Lion))
            return false;
        Lion otherLion = (Lion) obj;
        return this.idNumber == otherLion.idNumber;
    }
}
