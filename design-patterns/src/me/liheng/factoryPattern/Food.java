package me.liheng.factoryPattern;

public abstract class Food {
    private int quantity;

    // If we wanted to tighten our access control,
    // we could have declared these constructors with default or package‐level access
    public Food(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public abstract void consumed();
}



class Hay extends Food {
    public Hay(int quantity) {
        super(quantity);

    }
    @Override
    public void consumed() {
        System.out.println("Hay eaten: " + getQuantity());
    }
}

class Pellets extends Food {
    public Pellets(int quantity) {
        super(quantity);
    }
    @Override
    public void consumed() {
        System.out.println("Pellets eaten: " + getQuantity());
    }
}

class Fish extends Food {
    public Fish(int quantity) {
        super(quantity);
    }
    @Override
    public void consumed() {
        System.out.println("Fish eaten: " + getQuantity());
    }
}