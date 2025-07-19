package me.liheng;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BlockingNonBlockingFutureGet {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service;
        service = Executors.newSingleThreadExecutor();

        try {
            Future<String> future = service.submit(
                    () -> {
                        Thread.sleep(3_000);
                        return "Hello World.";
                    }
            );
            System.out.println(future.get()); //get() is called.
        } finally {
            if (service != null) service.shutdown();
        }
    }
}
