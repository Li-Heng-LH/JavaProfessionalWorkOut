package me.liheng.anonymousInnerClass;

public class Outer {

    interface SaleTodayOnly {
        int dollarsOff();
    }

    private int admission(int basePrice, SaleTodayOnly sale) {
        return basePrice - sale.dollarsOff();
    }

    public int pay() {
        return admission(10, new SaleTodayOnly() {
            @Override
            public int dollarsOff() {
                return 5;
            }
        });
    }

    public static void main(String[] args) {
        System.out.println(new Outer().pay());
    }
}
