package me.liheng;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class InvokeAndScheduleAtFixed {
    private static ExecutorService service = null;

    public static void main(String[] args) {
        try {
            invoke();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (service != null) service.shutdown();
        }
    }

    static void invoke() throws Exception {
        service = Executors.newSingleThreadExecutor();
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

    static void scheduleAtFixed() {
        //
    }
}
