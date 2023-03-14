package me.liheng;

public class ThreadFromRunnable {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> System.out.println("runnable's run."));

        // Both run and start calls runnable's run
        thread.run();   //runnable's run.
        thread.start(); //runnable's run.
    }
}
