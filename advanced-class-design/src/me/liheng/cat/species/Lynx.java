package me.liheng.cat.species;

import me.liheng.cat.BigCat;

public class Lynx extends BigCat {

    public static void main(String[] args) {
        BigCat cat = new BigCat();
        System.out.println(cat.name);
        //System.out.println(cat.hasFur);
        //System.out.println(cat.hasPaws);
        //System.out.println(cat.id);

        Lynx lynx = new Lynx ();
        System.out.println(lynx.name);
        System.out.println(lynx.hasFur); //can access now as hasFur is protected
        //System.out.println(lynx.hasPaws);
        //System.out.println(lynx.id);
    }
}
