package me.liheng.enums;

public enum OrdinalVSState {
    ONE(1),
    TWO(2),
    THREE(3);

    private int state;

    private OrdinalVSState(int i) {
        state = i;
    }

    public int getState() {
        return state;
    }

    public static void main(String[] args) {
        for (OrdinalVSState ordinalVSState : OrdinalVSState.values()) {
            System.out.println(ordinalVSState + " ordinal: " + ordinalVSState.ordinal());
            System.out.println(ordinalVSState + " state:   " + ordinalVSState.getState());
            System.out.println();
        }
    }
}
