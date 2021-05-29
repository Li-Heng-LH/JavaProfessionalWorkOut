package me.liheng.singleton;

public class HayStorage {
    private int quantity = 0;

    private HayStorage() {} //By marking the constructors private, we have implicitly marked the class final.

    private static final HayStorage instance = new HayStorage(); //Note instance can be final, as it is initialised inline

    public static HayStorage getInstance() {
        return instance;
    }

    public synchronized void addHay(int amount) {
        quantity += amount;
    }

    public synchronized boolean removeHay (int amount) {
        if(quantity < amount)
            return false;
        quantity -= amount;
        return true;
    }

    public synchronized int getHayQuantity() {
        return quantity;
    }
}
