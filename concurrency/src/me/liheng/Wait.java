package me.liheng;

public class Wait {

    public static void main(String[] args) {
        new ThreadA().start();
    }
}

class ThreadA extends Thread {
    @Override
    public void run() {
        ThreadB b = new ThreadB();
        b.start();

        synchronized (b) {
            System.out.println("a acquired lock of b");
            System.out.println("a waiting for b to complete...");
            try {
                b.wait(); //put me to the waiting list of b; called within synchronized context
                System.out.println("Total is: " + b.total);
            } catch (InterruptedException e) {
                System.out.println("Total is: " + b.total);
            }
        }
    }
}

class ThreadB extends Thread {
    int total = 0;

    @Override
    public void run() {
        synchronized (this) {
            System.out.println("b acquired lock of b");
            for (int i = 0; i < 100; i++) {
                total += i;
            }
            notify(); //called within synchronized context
        }
    }
}
