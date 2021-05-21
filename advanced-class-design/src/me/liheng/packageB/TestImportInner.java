package me.liheng.packageB;

import me.liheng.packageA.Outer;

public class TestImportInner {
    public static void main(String[] args) {

        Outer outer = new Outer();
        Outer.PublicInner publicInner = outer.new PublicInner();
    }
}
