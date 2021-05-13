package me.liheng.anonymousInnerClass;

public class AnonInner {

    abstract class SaleTodayOnly {
        abstract int dollarsOff();
    }

    public int admission(int basePrice) {
        SaleTodayOnly saleTodayOnly = new SaleTodayOnly() {
            int dollarsOff() {
                return 5;
            }
        };
        return basePrice - saleTodayOnly.dollarsOff();
    }

    public static void main(String[] args) {
        System.out.println(new AnonInner().admission(10));
    }

}
