package me.liheng;

public class CheckResults {

    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            for (int i = 0; i< 500000; i++) counter++;
        }).start();

        while (counter < 200000) {
            System.out.println("Not reached yet");
            Thread.sleep(1000); // 1 SECOND
        }

        System.out.println("Reached");
    }
}
