package com.dsa.arrays;

public class NullExample {
    public static void main(String[] args) {

        // syntax
        // dataType[] variableName = new dataType[]

        /* An Array of primitives is initialized with 0's */
        int[] rollNos = new int[3];
        System.out.println(rollNos[0]); // 0

        /* An Array of Objects is initialized with null  */
        String[] names = new String[3];
        System.out.println(names[0]); // null
    }
}
