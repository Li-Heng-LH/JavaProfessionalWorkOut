package me.liheng.genericInterface;

//Generic interface Shippable
public interface Shippable<T> {
    void ship (T t);
}

// 1st way to implement generic interface
class ShippableRobotCrate implements Shippable<Robot> {
    public void ship(Robot robot) {
        //no-op
    }
}

//2nd way to implement generic interface: generic class
class ShippableAbstractCrate<T> implements Shippable<T> {
    public void ship(T t) {
        //no-op
    }
}

//old way
class ShippableCrate implements Shippable {
    public void ship(Object t) {
        //no-op
    }
}

class Robot {}