package me.liheng;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class BlockingNonBlockingScheduledExecutorService {

    private static ScheduledExecutorService service = null;

    public static void main(String[] args) {
        try {
            test();
            System.out.println("Main");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (service != null) service.shutdown();
        }
    }

    static void test() throws Exception {
        service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread woken..");
        }, 0, 2, TimeUnit.SECONDS);
    }
}
