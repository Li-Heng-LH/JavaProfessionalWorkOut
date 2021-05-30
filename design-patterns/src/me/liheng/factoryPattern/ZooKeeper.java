package me.liheng.factoryPattern;

public class ZooKeeper {
    public static void main(String[] args) {

        final Food food = FoodFactory.getFood("polar bear");
        food.consumed();
    }
}
