package com.dsa.examples;

import java.util.ArrayList;

public class ArraylistExample {
    public static void main(String[] args) {

        /* Creating a new ArrayList with initial capacity of 3
        * the initial capacity will be dynamically extended */
        ArrayList<Integer> listNums = new ArrayList<>(3);
        listNums.add(1);
        listNums.add(2);
        listNums.add(3);
        listNums.add(4);
        listNums.add(5);

        System.out.println(listNums);
        System.out.println(listNums.get(1));
    }
}
