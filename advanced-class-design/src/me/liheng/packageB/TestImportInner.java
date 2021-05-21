package me.liheng.packageB;

import me.liheng.packageA.Outer;
import me.liheng.packageA.Outer.PublicInner;

public class TestImportInner {
    public static void main(String[] args) {

        PublicInner publicInner = new Outer().new PublicInner();

        // No access to protected/default/private inner classes.
    }
}
