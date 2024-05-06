package me.liheng.synchronizing;

/***
 * Thread-1 acquired lock A
 * Thread-1 acquiring lock B...
 * Thread-0 acquired lock A
 * Thread-0 acquiring lock B...
 * 5
 */
public class DeadLockFix {
    private static class Resource {
        public int value = 0;
    }
    private Resource resourceA = new Resource();
    private Resource resourceB = new Resource();

    public void read() {
        synchronized (resourceA) {
            System.out.println(Thread.currentThread().getName() + " acquired lock A");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " acquiring lock B...");
            synchronized (resourceB) {
                System.out.println(resourceB.value + resourceA.value);
            }
        }
    }
    public void write(int a, int b) {
        synchronized (resourceA) {
            System.out.println(Thread.currentThread().getName() + " acquired lock A");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " acquiring lock B...");
            synchronized (resourceB) {
                resourceA.value = a;
                resourceB.value = b;
            }
        }
    }

    public static void main(String[] args) {
        DeadLockFix fix = new DeadLockFix();
        Thread read = new Thread(() -> {
            fix.read();
        });
        Thread write = new Thread(() -> {
            fix.write(2, 3);
        });

        write.start();
        read.start();
    }
}
