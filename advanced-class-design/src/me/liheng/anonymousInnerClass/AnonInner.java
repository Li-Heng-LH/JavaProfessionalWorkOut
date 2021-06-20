package me.liheng.anonymousInnerClass;

public class AnonInner {

    interface SaleTodayOnly {
        int dollarsOff();
    }

    public int admission(int basePrice) {
        //This is an anonymous inner class
        //We could have named it in another class, eg: FiveDollarSale
        //Here, we are defining the implementation of dollarsOff()
        //and instantiating at the same time.
        SaleTodayOnly saleTodayOnly = new SaleTodayOnly() {
            //Yes, we can define other attributes here
            public int test = 9;
            public int dollarsOff() {
                return 5;
            }
            //Yes, we can define other methods here
            //But we can only access interface methods
            //as this class is seen as the interface
            public int getTest() {
                return test;
            }
        };
        return basePrice - saleTodayOnly.dollarsOff();
    }

    public static void main(String[] args) {
        System.out.println(new AnonInner().admission2(10));
    }

    // Rewrite above using lambda
    public int admission2(int basePrice) {
        SaleTodayOnly saleTodayOnly = () -> 5;
        return basePrice - saleTodayOnly.dollarsOff();
    }

}
