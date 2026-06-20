/*
 * PROBLEM: Ceiling of a Number
 * -------------------------------------------------------------------------
 * Given a sorted array of integers and a target value, find the index
 * of the smallest element that is greater than or equal to the target.
 *
 * Example 1:
 * Input: arr = [2, 3, 5, 9, 14, 16, 18], target = 10
 * Output: 4 (Element at index 4 is 14, which is the smallest number >= 10)
 *
 * Example 2:
 * Input: arr = [2, 3, 5, 9, 14, 16, 18], target = 20
 * Output: -1 (No element is >= 20)
 *
 * Complexity: Time O(log N) | Space O(1)
 * -------------------------------------------------------------------------
 */

package com.dsa.problems;

public class CeilingSearch {
    static int ceilingBinarySearch(int[] arr, int target) {

        // initializing start & end indices
        int startIndex = 0;
        int endIndex = arr.length - 1;
        int targetIndex = -1; // Default if no ceiling is found

        /* If startIndex exceeds the value of endIndex,
         * It means we finished searching the entire array */
        while (startIndex <= endIndex) {

            // to prevent overflow of integer if start and end indices are too large
            int midIndex = startIndex + (endIndex - startIndex)/2;

            if(arr[midIndex] == target) {
                return midIndex;
            }
            else if (arr[midIndex] < target) {
                startIndex = midIndex + 1;
            }
            else {
                // case when `arr[midIndex] > target`
                targetIndex = midIndex; // This is a candidate!
                endIndex = midIndex - 1; // But look left for a smaller ceiling
            }
        }

        return targetIndex;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 9, 14, 16, 18};
        int target = 18;
        int targetIndex = ceilingBinarySearch(arr, target);
        System.out.println("Index of Target Element: " + targetIndex);
    }
}
