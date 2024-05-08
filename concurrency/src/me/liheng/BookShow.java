package me.liheng;

import java.util.HashSet;
import java.util.Set;

/***
 * One possible outcome:
 * thread-two booking status for seat 1A: true
 * thread-two booking status for seat 1B: true
 * thread-one booking status for seat 1A: false
 * thread-one booking status for seat 1B: false
 * each seat can only be booked once
 */
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
                " booking status for seat " +
                seat +
                ": " +
                show.bookSeat(seat));
    }
}

class Show {
    private static volatile Show INSTANCE; //shared resource

    //Note that Set is not "thread-safe"
    private final Set<String> availableSeats; //shared resource

    /***
     * If not synchronized, this method may be executed by both threads,
     * defeating the purpose of singleton.
     */
    public static synchronized Show getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Show();
        }
        return INSTANCE;
    }

    /***
     * Need to synchronize here as Set is not "thread-safe"
     */
    public synchronized boolean bookSeat(String seat) {
        return availableSeats.remove(seat);
    }

    private Show() {
        availableSeats = new HashSet<>();
        availableSeats.add("1A");
        availableSeats.add("1B");
    }

}
