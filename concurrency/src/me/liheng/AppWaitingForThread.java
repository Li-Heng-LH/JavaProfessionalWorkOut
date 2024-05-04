package me.liheng;

/**
 * main: Main is done
 * Thread-0: I have woken
 */
public class AppWaitingForThread {
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + ": I have woken");
        });

        t1.start();

        System.out.println(Thread.currentThread().getName() + ": Main is done");
    }
}
