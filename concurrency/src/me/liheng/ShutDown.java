package me.liheng;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ShutDown {

    public static void main(String[] args) {
        ExecutorService service = null;

        try {
            service = Executors.newSingleThreadExecutor();
            Future<?> result = service.submit(() -> {
                while (true) {}
            });
            System.out.println(result.get(2, TimeUnit.SECONDS));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (service != null) service.shutdown();
        }

        if(service != null) {
            try {
                service.awaitTermination(10, TimeUnit.SECONDS);
                if(service.isTerminated()) System.out.println("Task finished");
                else System.out.println("Task not finished");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
