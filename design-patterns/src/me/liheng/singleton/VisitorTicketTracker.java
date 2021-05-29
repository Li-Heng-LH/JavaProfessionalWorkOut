package me.liheng.singleton;

//Lazy Instantiation
public class VisitorTicketTracker {

    private static VisitorTicketTracker instance;  //Note instance is not final

    private VisitorTicketTracker() {}

    public static VisitorTicketTracker getInstance() {
        if(instance == null) {
            instance = new VisitorTicketTracker(); // NOT THREAD-SAFE!
        }
        return instance;
    }

    // Data access methods

}
