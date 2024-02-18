package me.liheng.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicSheepManager {

    private AtomicInteger sheepCount = new AtomicInteger(0);
    private void incrementAndReport() {
        System.out.print(sheepCount.incrementAndGet() + " ");
    }

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(20);
            AtomicSheepManager manager = new AtomicSheepManager();
            for(int i = 0; i < 10; i++) {
                service.submit(manager::incrementAndReport);
            }
        } finally {
            if(service != null) service.shutdown();
        }
    }
}
