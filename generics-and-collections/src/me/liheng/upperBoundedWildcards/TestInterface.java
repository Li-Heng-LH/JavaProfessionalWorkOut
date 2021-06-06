package me.liheng.upperBoundedWildcards;

import java.util.ArrayList;
import java.util.List;

public class TestInterface {

    public static void main(String[] args) {
        List<? extends Flyer> list = new ArrayList<Goose>();
    }
}

interface Flyer {void fly();}
class HangGlider implements Flyer { public void fly() {} }
class Goose implements Flyer { public void fly() {} }