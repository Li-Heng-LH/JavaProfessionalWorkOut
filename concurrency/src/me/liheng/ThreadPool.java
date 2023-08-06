package me.liheng;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    private static ScheduledExecutorService service = null;

    public static void main(String[] args) {
        try {
            scheduledThreadPool();
            //Use main thread to wait for the tasks
            System.out.println("Main thread sleeping: " + Thread.currentThread());  //Thread[main,5,main]
            Thread.sleep(10_000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (service != null) service.shutdown();
        }
    }

    static void scheduledThreadPool() {
        service = Executors.newScheduledThreadPool(3);
        service.scheduleAtFixedRate(
                () -> System.out.println("Task: " + Thread.currentThread()),  //Thread[pool-1-thread-2,5,main]
                0,
                3,
                TimeUnit.SECONDS
        );
    }

    static void submitMultipleTasks() {}
}
