package me.liheng.OCA;

import java.util.Arrays;
import java.util.List;

public class ShallowCopy {

    public static void main(String[] args) {
        new ShallowCopy().test();
    }

    private void test() {
        Number [] array = {new Number(1), new Number(2), new Number(3)};
        List<Number> list = Arrays.asList(array);
        Number [] array2 = (Number []) list.toArray(); //Shallow copy

        System.out.println("Initial");
        ArrayAndArrayList.printArray(array);   //{1} {2} {3}
        printNumber(list);                     //{1} {2} {3}
        ArrayAndArrayList.printArray(array2);  //{1} {2} {3}

        //Shallow copy demonstration
        array[0].number = 100;
        System.out.println("After modifying array");
        ArrayAndArrayList.printArray(array);   //{100} {2} {3}
        printNumber(list);                     //{100} {2} {3}
        ArrayAndArrayList.printArray(array2);  //{100} {2} {3}
    }

    private void printNumber(List<Number> list) {
        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}


class Number {
    public int number;

    public Number(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "{" + number + "}";
    }
}