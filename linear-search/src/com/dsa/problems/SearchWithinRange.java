package com.dsa.problems;

import java.util.Arrays;

public class SearchWithinRange {

    static int linearSearchWithinRange(int[] arr, int target, int rangeStart, int rangeEnd) {

        /* Check for validity of start & end range */
        if(rangeStart > rangeEnd || rangeStart < 0 || rangeEnd > (arr.length - 1) ) {
            return -1;
        }

        for (int index = rangeStart; index <= rangeEnd; index++) {
            if (arr[index] == target) {
                return index;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 24, 12, 11, 9};
        int targetNum = 24;
        int rangeStart = 2;
        int rangeEnd = 4;
        int indexTarget = linearSearchWithinRange(nums, targetNum, rangeStart, rangeEnd);

        // Multiline string using text block in Java
        String resultText = """
                The targetNum element: %d
                Occurs at index: %d
                Within the index range of %d to %d
                Withing the array: %s
                """.formatted(targetNum, indexTarget, rangeStart, rangeEnd, Arrays.toString(nums));

        System.out.println(resultText);
    }
}
