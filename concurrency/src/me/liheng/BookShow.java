package me.liheng;

import java.util.HashSet;
import java.util.Set;

public class BookShow {

    public static void main(String[] args) {
        new BookShow().go();
    }
    public void go() {
        Thread getSeats1 = new Thread(() -> {
            ticketAgentBooks("1A");
            ticketAgentBooks("1B");
        }, "thread-one");

        Thread getSeats2 = new Thread(() -> {
            ticketAgentBooks("1A");
            ticketAgentBooks("1B");
        }, "thread-two");

        getSeats1.start();
        getSeats2.start();
    }
    public void ticketAgentBooks(String seat) {
        Show show = Show.getInstance();
        System.out.println(Thread.currentThread().getName() +
                " booking status: " +
                show.bookSeat(seat));
    }
}

class Show {
    private static Show INSTANCE;
    private final Set<String> availableSeats;

    /***
     * If not synchronized, this method may be executed by both threads,
     * defeating the purpose of singleton.
     */
    public static Show getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Show();
        }
        return INSTANCE;
    }

    public boolean bookSeat(String seat) {
        return availableSeats.remove(seat);
    }

    private Show() {
        availableSeats = new HashSet<>();
        availableSeats.add("1A");
        availableSeats.add("1B");
    }

}
