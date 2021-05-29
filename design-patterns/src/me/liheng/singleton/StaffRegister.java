package me.liheng.singleton;

public class StaffRegister {

    private static final StaffRegister instance; // Can be final becos of static initialization block

    static {
        instance = new StaffRegister();
        //Perform additional steps
    }

    private StaffRegister() {}

    public static StaffRegister getInstance() {
        return instance;
    }

    // Data access methods
}
