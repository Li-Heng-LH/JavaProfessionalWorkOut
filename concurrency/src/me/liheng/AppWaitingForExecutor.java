package me.liheng;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * main: Executed a task
 * pool-1-thread-1: I have woken
 */
public class AppWaitingForExecutor {
    public static void main(String[] args) {

        ExecutorService executor = null;
        try {
            executor = Executors.newSingleThreadExecutor();
            executor.execute(() -> {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + ": I have woken");
                try {
                    Thread.sleep(10_000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            System.out.println(Thread.currentThread().getName() + ": Executed a task");

        } finally {
            if (executor != null) executor.shutdown();
        }
    }
}
