package com.dsa.references;
import java.util.Arrays;

public class ReferenceTypeExamples {
    public static void main(String[] args) {
        String firstName = "Shri";
        String lastName = firstName;

        System.out.println("Before Change:");
        System.out.println("firstName : " + firstName); // Shri
        System.out.println("lastName : " + lastName); // Shri

        lastName = "Shetty";

        System.out.println("After Change:");
        System.out.println("firstName : " + firstName); // Shri
        System.out.println("lastName : " + lastName); // Shetty

        // let's try with an array of nums
        int[] naturalNums = {1, 2, 3, 4, 5};
        int[] wholeNums = naturalNums;

        System.out.println("Before Change:");
        System.out.println("naturalNums : " + Arrays.toString(naturalNums)); // [1, 2, 3, 4, 5]
        System.out.println("wholeNums : " + Arrays.toString(wholeNums)); // [1, 2, 3, 4, 5]

        // mutate the second arry and check if it reflects for the first array as well
        wholeNums[0] = 0;

        System.out.println("After Change:");
        System.out.println("naturalNums : " + Arrays.toString(naturalNums)); // [0, 2, 3, 4, 5]
        System.out.println("wholeNums : " + Arrays.toString(wholeNums)); // [0, 2, 3, 4, 5]
    }
}
