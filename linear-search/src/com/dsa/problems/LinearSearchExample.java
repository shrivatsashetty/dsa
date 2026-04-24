package com.dsa.problems;

import java.util.Arrays;

public class LinearSearchExample {

    /* The Linear Search function */
    static int linearSearch(int[] arr, int target) {
        if(arr.length == 0) {
            return -1;
        }

        for (int index = 0; index < arr.length; index++) {
            if (arr[index] == target) {
                return index;
            }
        }

        return -1;
    }

    /* Main Function */
    public static void main(String[] args) {
        int[] nums = {4, 24, 12, 11, 9};
        int targetNum = 24;
        int indexTarget = linearSearch(nums, targetNum);

        // multiline string using text block in Java
        String resultText = """
                The target element: %d
                Occurs at index: %d
                Withing the array: %s
                """.formatted(targetNum, indexTarget, Arrays.toString(nums));

        System.out.println(resultText);

    }
}
