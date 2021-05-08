package me.liheng.enums;

public enum OverrideSeason {

    WINTER {
        public void printHours() {
            System.out.println("short hours");
        }
    },

    SUMMER {
        public void printHours() {
            System.out.println("long hours");
        }
    },

    SPRING,
    FALL;

    public void printHours() {
        System.out.println("default hours");
    }

    public static void main(String[] args) {
        for (OverrideSeason overrideSeason : OverrideSeason.values()) {
            overrideSeason.printHours();
        }
    }
}
