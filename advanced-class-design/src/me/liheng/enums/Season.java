package me.liheng.enums;

public enum Season {
    WINTER,
    SPRING,
    SUMMER,
    FALL;

    public static void main(String[] args) {
        Season s = Season.SUMMER;
        System.out.println(s);                       // SUMMER
        System.out.println(Season.SUMMER);           // SUMMER
        System.out.println(s == Season.SUMMER);      // true, because they are like static final constants.
        System.out.println(s.equals(Season.SUMMER)); // true

        for(Season season: Season.values()) {
            System.out.println(season.name() + " " + season.ordinal());
        }
    }
}


