package me.liheng.synchronizing;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceExample {

    public static void main(String[] args) {
        AtomicReference<String> atomicRef = new AtomicReference<>("initial value");

        // Get and set operations
        String currentValue = atomicRef.get();
        atomicRef.set("new value");

        // Compare-and-Set operation
        boolean updated = atomicRef.compareAndSet("new value", "updated value");
        System.out.println("Update successful? " + updated);

        // Get the updated value
        String updatedValue = atomicRef.get();
        System.out.println("Updated value: " + updatedValue);
    }
}

