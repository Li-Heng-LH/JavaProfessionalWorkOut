package me.liheng;

// concurrency API
import java.util.concurrent.*;

public class SingleThreadExecutor {

    // Total number of threads: 2
    // main(), and
    // ExecutorService
    // ExecutorService thread will run the added tasks sequentially
    public static void main(String[] args) {

        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            System.out.println(Thread.currentThread().getId() + ": Begin");

            // execute takes in a Runnable
            service.execute(() -> System.out.println(Thread.currentThread().getId() + ": Starting to iterate..."));

            // Reusing the thread? to execute another task
            service.execute(() -> {
                for (int i = 0; i < 3; i++)
                    System.out.println(Thread.currentThread().getId() + ": " + i);
            });

            service.execute(() -> System.out.println(Thread.currentThread().getId() + ": Done iterating."));

            System.out.println(Thread.currentThread().getId() + ": End");
        } finally {
            if(service != null) service.shutdown();
        }
    }
}
