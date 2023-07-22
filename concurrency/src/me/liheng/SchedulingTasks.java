package me.liheng;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class SchedulingTasks {

    public static void main(String[] args) {
        ScheduledExecutorService service = null;
        try {
            scheduleAtFixedRate(service);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (service != null) service.shutdown();
        }
    }

    private static void scheduleTasks(ScheduledExecutorService service) throws Exception {
        service = Executors.newSingleThreadScheduledExecutor();
        ScheduledFuture<Integer> result1 = service.schedule(() -> 111, 5, TimeUnit.SECONDS);
        ScheduledFuture<Integer> result2 = service.schedule(() -> 222, 5, TimeUnit.SECONDS);
        //count down starts at the same time

        System.out.println("result1 getDelay: " + result1.getDelay(TimeUnit.SECONDS));
        System.out.println("result2 getDelay: " + result2.getDelay(TimeUnit.SECONDS));
        System.out.println(result1.get());  //blocking

        System.out.println("result1 getDelay: " + result1.getDelay(TimeUnit.SECONDS));
        System.out.println("result2 getDelay: " + result2.getDelay(TimeUnit.SECONDS));
        System.out.println(result2.get());  //blocking
    }

    private static void scheduleAtFixedRate(ScheduledExecutorService service) throws Exception {
        service = Executors.newSingleThreadScheduledExecutor();
        ScheduledFuture<?> result = service.scheduleAtFixedRate(() -> {
            System.out.println("" + Thread.currentThread() + " running.");
            //while(true) {} //blocking
        }, 3, 3, TimeUnit.SECONDS);
        Thread.sleep(1000);
        System.out.println(result.getDelay(TimeUnit.SECONDS));
        System.out.println(result.get(10, TimeUnit.SECONDS));  //TimeoutException
    }
}
