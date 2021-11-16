package me.liheng.builderAndStaticInnerClass;

import me.liheng.builderAndStaticInnerClass.Car.*;

public class Runner {

    public static void main(String[] args) {
        Car car = new CarBuilder()
                .setName("AA")
                .setNumber(123)
                .setBrand("BB")
                .setAge(1)
                .build();

        System.out.println(car);
    }
}
