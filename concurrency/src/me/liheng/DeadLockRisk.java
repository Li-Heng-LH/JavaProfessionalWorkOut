package me.liheng;

/***
 * Thread-1 acquired lock B
 * Thread-0 acquired lock A
 * Thread-1 acquiring lock A...
 * Thread-0 acquiring lock B...
 */
public class DeadLockRisk {
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
        synchronized (resourceB) {
            System.out.println(Thread.currentThread().getName() + " acquired lock B");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " acquiring lock A...");
            synchronized (resourceA) {
                resourceA.value = a;
                resourceB.value = b;
            }
        }
    }

    public static void main(String[] args) {
        DeadLockRisk risk = new DeadLockRisk();
        Thread read = new Thread(() -> {
            risk.read();
        });
        Thread write = new Thread(() -> {
            risk.write(2, 3);
        });

        write.start();
        read.start();
    }
}
