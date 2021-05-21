package me.liheng.packageB;

import me.liheng.packageA.Enclosing.PublicInner; // add static also fine

public class TestImportStaticNested {
    public static void main(String[] args) {

        PublicInner publicInner = new PublicInner();
    }
}
