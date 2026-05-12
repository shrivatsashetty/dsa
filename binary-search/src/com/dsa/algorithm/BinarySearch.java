package com.dsa.algorithm;

public class BinarySearch {

    /* An integer value to keep track of how many iterations were required
     * to find the index of the target element  */
    static int iterations = 0;

    static int binarySearch(int[] arr, int target) {

        int startIndex = 0;
        int endIndex = arr.length - 1;

        while (startIndex <= endIndex) {
            iterations += 1;

            // to prevent overflow of integer if start and end indices are too large
            int midIndex = startIndex + (endIndex - startIndex)/2;

            if(arr[midIndex] == target) {
                return midIndex;
            } else if (arr[midIndex] < target) {
                startIndex = midIndex + 1;
            } else {
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
        System.out.println("No of Iterations: " + iterations);
    }
}
