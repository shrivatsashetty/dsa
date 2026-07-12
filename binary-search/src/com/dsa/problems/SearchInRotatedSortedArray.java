/*
There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function, nums is possibly left rotated at an unknown index k (1 <= k < nums.length),
such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
For example, [0,1,2,4,5,6,7] might be left rotated by 3 indices and become [4,5,6,7,0,1,2].
Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums,
or -1 if it is not in nums.
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Example 3:
Input: nums = [1], target = 0
Output: -1

Constraints:
1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is an ascending array that is possibly rotated.
-104 <= target <= 104
* */

package com.dsa.problems;

public class SearchInRotatedSortedArray {
    /* A method to perform classic Binary Search */
    static int rangeBinarySearch(int[] arr, int target, int indexStart, int indexEnd) {

        int startIndex = indexStart;
        int endIndex = indexEnd;

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

    /* A method to check whether the array is rotated or not */
    static boolean isArrayRotated(int[] arr) {
        int endIndex = arr.length - 1;

        /* In a rotated array that was obtained by rotating an ascending sorted array
         * the first element is always greater than the last */
        return arr[0] > arr[endIndex];
    }

    /* A method to find the index of the pivot element */
    static int findPivotIndex(int[] arr) {

        int startIndex = 0;
        int endIndex = arr.length - 1;

        while (startIndex <= endIndex) {
            // to prevent overflow of integer if start and end indices are too large
            int midIndex = startIndex + (endIndex - startIndex)/2;

            if (arr[midIndex] > arr[midIndex + 1]) {
                return midIndex;
            } else {
                // condition when: arr[m] < arr[m + 1]
                // condition: arr[m] == arr[m + 1] not possible,
                // since all elements are unique
                if (arr[midIndex] >= arr[0]) {
                    startIndex = midIndex + 1;
                } else {
                    endIndex = midIndex - 1;
                }
            }
        }

        return -1;
    }

    public static int search(int[] nums, int target) {
        int targetIndex;

        if(isArrayRotated(nums)) {
            /* If the array was rotated, we find the index of pivot index,
             * i.e. the index around which the array was rotated */
            int pivotIndex = findPivotIndex(nums);

            /* Perform a binary search of the first half of the rotated array */
            targetIndex = rangeBinarySearch(nums, target, 0, pivotIndex);

            if(targetIndex == -1) {
                /* If the target was not found in the first half of the rotated array,
                 * Return whatever result was found,
                 * by performing a Binary Search on the second half of the array */
                return rangeBinarySearch(nums, target, pivotIndex, (nums.length - 1));
            }

            return targetIndex;
        }

        targetIndex = rangeBinarySearch(nums, target, 0, (nums.length - 1));

        return targetIndex;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1 }; // this case if failing
        int target = 1;
        int targetIndex = search(arr, target);
        System.out.println("Index of Target Element: " + targetIndex);
    }
}
