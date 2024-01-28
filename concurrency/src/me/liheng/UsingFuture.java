package me.liheng;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class UsingFuture {

    public static void main(String[] args) {
        getWithTimeOut();
    }

    public static void futureDotGet() {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            Future<Integer> future = service.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " Waiting...");
                Thread.sleep(2_000);
                return 99;
            });
            System.out.println(Thread.currentThread().getName() + " " + future.get());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }

    public static void getWithTimeOut() {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            Future<Integer> future = service.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " Waiting...");
                Thread.sleep(5_000);
                return 1;
            });
            System.out.println(future.get(2, TimeUnit.SECONDS));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (service != null) service.shutdown();
        }
    }
}
