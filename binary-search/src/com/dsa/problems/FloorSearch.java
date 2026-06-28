package com.dsa.problems;

public class FloorSearch {

    static int floorBinarySearch(int[] arr, int target) {

        /* Handling the case when target element is smaller
         * than the smallest number in the array */
        if (target < arr[0]) {
            return -1;
        }

        int startIndex = 0;
        int endIndex = arr.length - 1;

        while (startIndex <= endIndex) {

            // to prevent overflow of integer if start and end indices are too large
            int midIndex = startIndex + (endIndex - startIndex) / 2;

            if (arr[midIndex] == target) {
                return midIndex;
            } else if (arr[midIndex] < target) {
                startIndex = midIndex + 1;
            } else {
                endIndex = midIndex - 1;
            }
        }

        return endIndex;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 7, 11, 14, 16, 18};
        int target = 17;
        int targetIndex = floorBinarySearch(arr, target);
        System.out.println("Index of Target Element: " + targetIndex);
    }
}