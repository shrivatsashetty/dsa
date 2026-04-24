package com.dsa.problems;

import java.util.Arrays;

public class SearchMinimumNumber {
    /*This method takes an array as input and
    * returns the index of the smallest element within the array */
    static int getMinimumNumber(int[] arr) {

        /* If the Array is empty, return -1
         * to avoid "Null Pointer Exception" */
        if(arr.length == 0) {
            return -1;
        }

        int minimum = arr[0];
        int indexMinimum = 0;

        for (int index = 0; index < arr.length; index++) {
            if(arr[index] < minimum) {
                indexMinimum = index;
            }
        }

        return indexMinimum;
    }

    public static void main(String[] args) {
        int[] nums = {24, 4, 12, 11, 9};
        int indexTarget = getMinimumNumber(nums);

        // multiline string using text block in Java
        String resultText = """
                The minimum value occurs at index: %d
                Withing the array: %s
                """.formatted(indexTarget, Arrays.toString(nums));

        System.out.println(resultText);
    }
}
