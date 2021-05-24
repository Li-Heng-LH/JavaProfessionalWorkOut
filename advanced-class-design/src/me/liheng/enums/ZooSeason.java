package me.liheng.enums;

public enum ZooSeason {

    //assign a state to each enum
    WINTER("Low"),
    SPRING("Medium"),
    SUMMER("High"),
    FALL("Medium");

    private String expectedVisitors;

    private ZooSeason (String expectedVisitors) {  // Enums are not allowed to have a public constructor
        this.expectedVisitors = expectedVisitors;
    }

    public void printExpectedVisitors() {
        System.out.println(expectedVisitors);
    }

    public static void main(String[] args) {
        ZooSeason.SUMMER.printExpectedVisitors();
    }
}
