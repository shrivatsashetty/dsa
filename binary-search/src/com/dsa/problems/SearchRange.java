
/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:
Input: nums = [], target = 0
Output: [-1,-1]

Constraints:
0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109

*/

package com.dsa.problems;

import java.util.Arrays;

public class SearchRange {

    public static int[] searchRange(int[] nums, int target) {

        int[] range = {-1, -1};

        /* If the target element is an empty array,
         * Just return {-1, -1} as there's no need to search */
        if(nums.length == 0) {
            return range;
        }

        int indexFirstOccurrence = getFirstOccurrence(nums, target);
        int indexLastOccurrence = getLastOccurrence(nums, target);

        range[0] = indexFirstOccurrence;
        range[1] = indexLastOccurrence;

        return range;
    }

    /* Helper Method,
     * Returns the index of the first occurrence of a target in the given array */
    public static int getFirstOccurrence(int[] arr, int target) {

        /* Case when the target is not found in the array */
        if( (target < arr[0]) || (target > arr[arr.length - 1]) ) {
            return -1;
        }

        int startIndex = 0;
        int endIndex = arr.length - 1;

        while (startIndex <= endIndex) {

            // to prevent overflow of integer if start and end indices are too large
            int midIndex = startIndex + (endIndex - startIndex)/2;

            if ((arr[midIndex] < target)) {
                startIndex = midIndex + 1;

            } else {
                // condition when `arr[midIndex] >= target`
                endIndex = midIndex - 1;
            }
        }

        // return the startIndex only of the target exists in the array
        if(arr[startIndex] == target) {
            return startIndex;
        }

        return -1;

    }

    /* Helper Method,
     * Returns the index of the last occurrence of a target in the given array */
    public static int getLastOccurrence(int[] arr, int target) {

        /* Case when the target is not found in the array */
        if( (target < arr[0]) || (target > arr[arr.length - 1]) ) {
            return -1;
        }

        int startIndex = 0;
        int endIndex = arr.length - 1;

        while (startIndex <= endIndex) {

            // to prevent overflow of integer if start and end indices are too large
            int midIndex = startIndex + (endIndex - startIndex)/2;

            if ((arr[midIndex] > target)) {
                endIndex = midIndex - 1;
            } else {
                // condition when `arr[midIndex] <= target`
                startIndex = midIndex + 1;
            }
        }

        // return the endIndex only of the target exists in the array
        if(arr[endIndex] == target) {
            return endIndex;
        }

        return -1;

    }

    public static void main(String[] args) {
        int[] arr = { 3, 3, 3, 7, 7, 8, 11, 11, 11, 11, 11, 11, 14 };
        int target = 11;
        int[] targetRange = searchRange(arr, target);
        System.out.println("Range of Target Element: " + Arrays.toString(targetRange));
    }

}
