package me.liheng;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BlockingNonBlockingSubmit {

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
            //Note: get() is NOT called.
        } finally {
            if (service != null) service.shutdown();
        }
    }
}
