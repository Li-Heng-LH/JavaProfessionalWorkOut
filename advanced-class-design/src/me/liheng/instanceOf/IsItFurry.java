package me.liheng.instanceOf;

import java.util.ArrayList;

public class IsItFurry {

    static class Chipmunk {
        //no-op
    }

    public static void main(String[] args) {
        Chipmunk c = new Chipmunk();
        ArrayList<Chipmunk> l = new ArrayList<>();
        Runnable r = new Thread();
        int result = 0;

        if (c instanceof Chipmunk) result += 1;
        // if (l instanceof Chipmunk) result += 2; // Compilation error: compilation check applies here on a concrete class
        if (r instanceof Chipmunk) result += 4;    // Compilation check does not apply on interface
        System.out.println(result);
    }
}
