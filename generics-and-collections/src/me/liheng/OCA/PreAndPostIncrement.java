package me.liheng.OCA;

public class PreAndPostIncrement {

    public static void main(String[] args) {
        System.out.println(pre());   // 1
        System.out.println(post());  // 0
    }

    static int pre() {
        int x = 0;
        return ++x;  // 1
    }

    static int post() {
        int x = 0;
        return x++;  // 0
    }
}
