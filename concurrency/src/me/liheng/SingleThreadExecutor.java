package me.liheng;

// concurrency API
import java.util.concurrent.*;

public class SingleThreadExecutor {

    public static void main(String[] args) {

        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            System.out.println("Begin");

            // execute takes in a Runnable
            service.execute(() -> System.out.println("Starting to iterate..."));

            // Reusing the thread? to execute another task
            service.execute(() -> {
                for (int i = 0; i < 3; i++)
                    System.out.println(i);
            });

            service.execute(() -> System.out.println("Done iterating."));

            System.out.println("End");
        } finally {
            if(service != null) service.shutdown();
        }
    }
}
