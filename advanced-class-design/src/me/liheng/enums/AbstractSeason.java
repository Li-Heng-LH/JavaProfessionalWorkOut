package me.liheng.enums;

public enum AbstractSeason {

    WINTER {
        public void printHours() {
            System.out.println("9am-3pm");
        }
    },

    SPRING {
        public void printHours() {
            System.out.println("9am-5pm");
        }
    },

    SUMMER {
        public void printHours() {
            System.out.println("9am-7pm");
        }
    },

    FALL {
        public void printHours() {
            System.out.println("9am-5pm");
        }
    };

    public abstract void printHours();

    public static void main(String[] args) {
        for (AbstractSeason abstractSeason : AbstractSeason.values()) {
            abstractSeason.printHours();
        }
    }
}
