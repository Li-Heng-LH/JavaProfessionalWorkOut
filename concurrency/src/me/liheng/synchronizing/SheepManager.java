package me.liheng.synchronizing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SheepManager {

    /**
     * Race condition
     * may have repetition,
     * for example: 1 2 2 ...
     */
    private int sheepCount = 0;
    private void incrementAndReport() {
        sheepCount = sheepCount + 1;
        System.out.print(sheepCount+" ");
    }

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(20);
            SheepManager manager = new SheepManager();
            for(int i = 0; i < 10; i++) {
                service.submit(manager::incrementAndReport);
            }
        } finally {
            if(service != null) service.shutdown();
        }
    }
}
