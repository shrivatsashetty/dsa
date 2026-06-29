package com.dsa.algorithm;

public class BinarySearch {

    static int binarySearch(int[] arr, int target) {

        int startIndex = 0;
        int endIndex = arr.length - 1;

        while (startIndex <= endIndex) {
            // to prevent overflow of integer if start and end indices are too large
            int midIndex = startIndex + (endIndex - startIndex)/2;

            if(arr[midIndex] == target) {
                return midIndex;
            } else if (arr[midIndex] < target) {
                startIndex = midIndex + 1;
            } else {
                // condition when: `arr[midIndex] > target`
                endIndex = midIndex - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 8, 14, 19, 21, 30};
        int target = 8;
        int targetIndex = binarySearch(arr, target);
        System.out.println("Index of Target Element: " + targetIndex);
    }
}
