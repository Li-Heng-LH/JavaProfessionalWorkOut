package me.liheng.ObjectMethods;

public class ToString {

    public static void main(String[] args) {
        Hippo hippo = new Hippo("Harry", 3100);
        System.out.println(hippo);
    }
}



class Hippo {
    private String name;
    private double weight;
    public Hippo(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }
}