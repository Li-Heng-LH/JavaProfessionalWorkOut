package me.liheng;

import java.util.concurrent.*;

public class UsingSubmit {
    private static int counter = 0;

    public static void main(String[] args) {

        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            Future<Integer> result = submitCallable(service);
            System.out.println("Future result: " + result.get(10, TimeUnit.SECONDS)); //Blocking
            System.out.println("Counter: " + counter);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (service != null) service.shutdown();
        }
    }

    private static Future<?> submitRunnable(ExecutorService service) {
        return service.submit(() -> {
            for (int i = 0; i < 500; i++) counter++;
        });
    }

    private static Future<Integer> submitCallable(ExecutorService service) {
        return service.submit(() -> 33 + 55);
    }
}
