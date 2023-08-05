package me.liheng;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class InvokeAndScheduleAtFixed {
    private static ScheduledExecutorService service = null;

    public static void main(String[] args) {
        try {
            submit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (service != null) service.shutdown();
        }
    }

    static void invoke() throws Exception {
        service = Executors.newSingleThreadScheduledExecutor();
        List<Callable<Integer>> futures = Arrays.asList(
                () -> {System.out.println(Thread.currentThread()); Thread.sleep(2_000); return 1;},
                () -> {System.out.println(Thread.currentThread()); Thread.sleep(2_000); return 2;},
                () -> {System.out.println(Thread.currentThread()); Thread.sleep(2_000); return 3;}
        );
        //invokeAll is blocking.
        //waiting for all the tasks to finish.
        for (Future<Integer> future : service.invokeAll(futures)) {
            System.out.println(future.get());
        }
    }

    static void scheduleAtFixed() throws Exception {
        service = Executors.newSingleThreadScheduledExecutor();
        ScheduledFuture<?> future = service.scheduleAtFixedRate(
                () -> System.out.println(Thread.currentThread()),
                0,
                1,
                TimeUnit.SECONDS
        );
        System.out.println("future.get(): " + future.get());  //blocking(waiting)
    }

    static void submit() throws Exception {
        service = Executors.newSingleThreadScheduledExecutor();
        Future<Integer> future = service.submit(() -> {
            System.out.println(Thread.currentThread());
            Thread.sleep(3_000);
            return 2;
        });
        System.out.println("future.get(): " + future.get()); //blocking(waiting)
    }
}
