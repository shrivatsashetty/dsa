package com.dsa.algorithm;

/* Binary Search Algorithm using Recursion */
public class BinarySearchRecursive {

    /* An integer value to keep track of how many iterations were required
     * to find the index of the target element  */
    static int iterations = 0;

    static int binarySearch(int[] arr, int target, int idxStart, int idxEnd) {
        iterations += 1;

        int startIndex = idxStart;
        int endIndex = idxEnd;
        // to pervent overflow of integer if start and end indices are too large
        int midIndex = startIndex + (endIndex - startIndex)/2;

        if (idxStart > idxEnd) {
            return -1;
        }

        if(arr[midIndex] == target) {
            return midIndex;
        } else if (arr[midIndex] < target) {
            startIndex = midIndex + 1;
        } else {
            endIndex = midIndex - 1;
        }

        /* If the target element is not fond in the first iteration,
         * the Binary search algorithm makes a recursive call to itself
         * with the updated start & end indices */
        return binarySearch(arr, target, startIndex, endIndex);
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 8, 14, 19, 21, 30};
        int target = 8;
        int targetIndex = binarySearch(arr, target, 0, (arr.length - 1));
        System.out.println("Index of Target Element: " + targetIndex);
        System.out.println("No of Iterations: " + iterations);
    }
}
