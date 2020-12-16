package me.liheng.cat;

public class CatAdmirer {

    public static void main(String[] args) {
        BigCat cat = new BigCat();
        System.out.println(cat.name); //name is public
        System.out.println(cat.hasFur); //hasFur is protected --> allows package access
        System.out.println(cat.hasPaws); //hasPaws is default --> package access
        //System.out.println(cat.id);
    }

}
