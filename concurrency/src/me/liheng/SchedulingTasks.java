package me.liheng;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class SchedulingTasks {

    public static void main(String[] args) {
        ScheduledExecutorService service = null;

        try {
            service = Executors.newSingleThreadScheduledExecutor();
            ScheduledFuture<Integer> result1 = service.schedule(() -> 11 + 22, 5, TimeUnit.SECONDS);
            ScheduledFuture<Integer> result2 = service.schedule(() -> 33 + 55, 5, TimeUnit.SECONDS);
            //count down starts at the same time

            System.out.println("result1 getDelay: " + result1.getDelay(TimeUnit.SECONDS));
            System.out.println("result2 getDelay: " + result2.getDelay(TimeUnit.SECONDS));
            System.out.println(result1.get());  //blocking

            System.out.println("result1 getDelay: " + result1.getDelay(TimeUnit.SECONDS));
            System.out.println("result2 getDelay: " + result2.getDelay(TimeUnit.SECONDS));
            System.out.println(result2.get());  //blocking
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (service != null) service.shutdown();
        }
    }
}
