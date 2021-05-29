package me.liheng.singleton;

//Lazy Instantiation
public class VisitorTicketTracker {

    private static VisitorTicketTracker instance;  //Note instance is not final

    private VisitorTicketTracker() {}

    //synchronized : only one thread will be allowed in the method at a time,
    //ensuring that only one object is created
    public static synchronized VisitorTicketTracker getInstance() {
        if(instance == null) {
            instance = new VisitorTicketTracker();
        }
        return instance;
    }

    // Data access methods

}
