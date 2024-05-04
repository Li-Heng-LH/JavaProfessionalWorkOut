package me.liheng;

/**
 * Thread-0: I have woken
 * main: Main is done
 */
public class Join {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + ": I have woken");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t1.join(); //current (main) thread to join on t1 --> run when t1 finishes

        System.out.println(Thread.currentThread().getName() + ": Main is done");
    }
}
