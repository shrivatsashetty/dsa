
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

public class SearchRangeAlternate {

    public static int[] searchRange(int[] nums, int target) {


        int[] range = {-1, -1};

        range[0] = find(nums, target, true);

        /* If the first occurrence itself is not found in the target array,
         * It means that the target element does not exist within the array
         * And there's no need to further search for the last occurrence */
        if (range[0] != -1) {
            range[1] = find(nums, target, false);
        }

        return range;
    }

    public static int find(int[] arr, int target, boolean findStart) {

        int targetIndex = -1;

        int startIndex = 0;
        int endIndex = arr.length - 1;

        while (startIndex <= endIndex) {

            // to prevent overflow of integer if start and end indices are too large
            int midIndex = startIndex + (endIndex - startIndex)/2;

            if ((arr[midIndex] < target)) {
                startIndex = midIndex + 1;
            } else if (arr[midIndex] > target) {
                endIndex = midIndex - 1;
            } else {
                /* condition when `arr[midIndex] == target`
                 * i.e. the exact element is found
                 * ths is the case of potential answer */
                targetIndex = midIndex;

                if(findStart) {
                    endIndex = midIndex -1;
                } else {
                    startIndex = midIndex + 1;
                }
            }
        }

        return targetIndex;

    }


    public static void main(String[] args) {
        int[] arr = { 3, 3, 3, 7, 7, 8, 11, 11, 11, 11, 11, 11, 14 };
        int target = 11;
        int[] targetRange = searchRange(arr, target);
        System.out.println("Range of Target Element: " + Arrays.toString(targetRange));
    }

}
