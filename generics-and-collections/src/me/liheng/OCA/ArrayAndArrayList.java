package me.liheng.OCA;

import java.util.Arrays;
import java.util.List;

public class ArrayAndArrayList {

    public static void main(String[] args) {
        new ArrayAndArrayList().test();
    }

    private void test() {
        String[] array = {"A", "B", "C"};
        List<String> list = Arrays.asList(array);     // Returns a fixed-size list backed by the specified array.
        String[] array2 = (String[]) list.toArray();  // The returned array will be "safe" in that no references to it are maintained by this list.

        System.out.println("Initial");
        printArray(array);    //A B C
        printList(list);      //A B C
        printArray(array2);   //A B C

        System.out.println("Change element in array");
        array[0] = "One";
        printArray(array);    //One B C
        printList(list);      //One B C
        printArray(array2);   //A B C

        System.out.println("Change element in list");
        list.set(1, "Two");
        printArray(array);   //One Two C
        printList(list);     //One Two C
        printArray(array2);  //A B C

        System.out.println("Trying to add element to list...");
        list.add("D");       //UnsupportedOperationException. list is not resizable
    }


    public static void printArray(String [] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void printList(List<String> list) {
        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
