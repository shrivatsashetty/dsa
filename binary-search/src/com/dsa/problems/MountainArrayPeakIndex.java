/*
* You are given an integer mountain array arr of length n where the values increase to a peak element and then decrease.

Return the index of the peak element.

Your task is to solve it in O(log(n)) time complexity.

Example 1:
Input: arr = [0,1,0]
Output: 1

Example 2:
Input: arr = [0,2,1,0]
Output: 1

Example 3:
Input: arr = [0,10,5,2]
Output: 1

Constraints:
3 <= arr.length <= 105
0 <= arr[i] <= 106
arr is guaranteed to be a mountain array.
* */

package com.dsa.problems;

public class MountainArrayPeakIndex {
    static int peakIndexInMountainArray(int[] arr) {

        int startIndex = 0;
        int endIndex = arr.length - 1;

        while (startIndex <= endIndex) {
            // to prevent overflow of integer if start and end indices are too large
            int midIndex = startIndex + (endIndex - startIndex)/2;

            if(arr[midIndex] <= arr[midIndex + 1]) {
                startIndex = midIndex + 1;
            } else {
                // condition when: `arr[midIndex] > arr[midIndex + 1]`
                endIndex = midIndex - 1;
            }
        }

        return startIndex;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 7, 3, 2};
        int peakIndex = peakIndexInMountainArray(arr);
        System.out.println("Index of Peak Element: " + peakIndex);
    }
}
