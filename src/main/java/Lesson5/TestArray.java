package Lesson5;

import Lesson2.Array;

public class TestArray {

    public static void main(String[] args) {
        Array<Integer> array = new RecSortedArraImpl<>(5);
        array.add(1);
        array.add(5);
        array.add(3);
        array.add(2);
        array.add(4);
        array.add(6);

        System.out.println("Size is " + array.size());
        System.out.println("Find 1: " + array.contains(1));
        System.out.println("Find 6: " + array.contains(6));
        System.out.println("Find 666: " + array.contains(666));
        System.out.println("Find index for 3: " + array.indexOf(3));

        array.remove(3);
        System.out.println("Find index for 3: " + array.indexOf(3));
    }

}
