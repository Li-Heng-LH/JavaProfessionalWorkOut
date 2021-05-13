package me.liheng.anonymousInnerClass;

public class AnonInner {

    interface SaleTodayOnly {
        int dollarsOff();
    }

    public int admission(int basePrice) {
        SaleTodayOnly saleTodayOnly = new SaleTodayOnly() {
            public int dollarsOff() {
                return 5;
            }
        };
        return basePrice - saleTodayOnly.dollarsOff();
    }

    public static void main(String[] args) {
        System.out.println(new AnonInner().admission(10));
    }

}
