/*
*
* Given a sorted array arr[] (in strictly increasing order) that has been right-rotated k times.
* A right rotation means the last element is moved to the first position,
* and the remaining elements are shifted one position to the right.
* Find the value of k the number of times the array was right-rotated from its originally sorted form.
*
* Examples
Input: arr[] = [15, 18, 2, 3, 6, 12]
Output: 2
Explanation:
Original sorted array = [2, 3, 6, 12, 15, 18]
After 2 right rotations → [15, 18, 2, 3, 6, 12]

Input: arr[] = [7, 9, 11, 12, 5]
Output: 4
Explanation:
Original sorted array = [5, 7, 9, 11, 12]
After 4 right rotations → [7, 9, 11, 12, 5]

Input: arr[] = [7, 9, 11, 12, 15]
Output: 0
Explanation: Array is already sorted, so k = 0
* */


package com.dsa.problems;

public class RotationCount {

    /* A method to check whether the array is rotated or not */
    static boolean isArrayRotated(int[] arr) {
        int endIndex = arr.length - 1;

        /* In a rotated array that was obtained by rotating an ascending sorted array
         * the first element is always greater than the last */
        return arr[0] > arr[endIndex];
    }

    /* A method to find the index of the pivot element of the rotated array */
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
                // condition: arr[m] == arr[m + 1] not possible, since all elements are unique
                if (arr[midIndex] >= arr[0]) {
                    startIndex = midIndex + 1;
                } else {
                    endIndex = midIndex - 1;
                }
            }
        }

        return -1;
    }

    /* A utility method to find how many times the array was rotated */
    static int findKRotation(int[] arr) {

        if(isArrayRotated(arr)) {
            return findPivotIndex(arr) + 1;
        }

        return 0;
    }

    /* Method to find the minimum element in the roted array */
    static int findMin(int[] nums) {
        if (isArrayRotated(nums)) {
            int pivotIndex = findPivotIndex(nums);
            int minIndex = pivotIndex + 1;
            return nums[minIndex];
        }

        // if the array is not rotated, the first element of the array itself will be the smallest element
        return nums[0];
    }

    public static void main(String[] args) {
        int[] arr = {11,13,15,17};
        int numRotations = findMin(arr);
        System.out.println("Smallest Element: " + numRotations);
    }

}
