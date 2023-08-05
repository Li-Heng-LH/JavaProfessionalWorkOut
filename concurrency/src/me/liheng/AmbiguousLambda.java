package me.liheng;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class AmbiguousLambda {
    //

    public static void main(String[] args) {
        // use(() -> 9); //Ambiguous method call.
        // use(() -> {throw new Exception();}); //Ambiguous method call.
        use((Callable<Integer>) () -> 9);  //explicit cast
    }

    public static void use(Supplier<Integer> supplier) {}
    public static void use(Callable<Integer> callable) {}
}
