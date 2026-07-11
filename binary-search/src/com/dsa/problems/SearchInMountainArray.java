/*
* (This problem is an interactive problem.)

You may recall that an array arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target. If such an index does not exist, return -1.

You cannot access the mountain array directly. You may only access the array using a MountainArray interface:

MountainArray.get(k) returns the element of the array at index k (0-indexed).
MountainArray.length() returns the length of the array.
Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer. Also, any solutions that attempt to circumvent the judge will result in disqualification.

Example 1:
Input: mountainArr = [1,2,3,4,5,3,1], target = 3
Output: 2
Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.

Example 2:
Input: mountainArr = [0,1,2,4,2,1], target = 3
Output: -1
Explanation: 3 does not exist in the array, so we return -1.


Constraints:
3 <= mountainArr.length() <= 104
0 <= target <= 109
0 <= mountainArr.get(index) <= 109
*
* */

package com.dsa.problems;

public class SearchInMountainArray {

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

    static int findFirstInRange(int[] arr, int target, int indexStart, int indexEnd) {
        int targetIndex = -1;
        int startIndex = indexStart;
        int endIndex = indexEnd;

        /* If first & the last elements are same,
         * then there's only one element in the array
         * or all elements are equal in the array */
        if(arr[startIndex] == arr[endIndex]) {
            if (arr[startIndex] == target) {
                return 0;
            }
            else {
                return -1;
            }
        }

        boolean isAscending = arr[startIndex] < arr[endIndex];


        while (startIndex <= endIndex) {

            // to prevent overflow of integer if start and end indices are too large
            int midIndex = startIndex + (endIndex - startIndex)/2;

            if(arr[midIndex] == target) {
                targetIndex = midIndex; // a potential answer
                endIndex = midIndex -1;
                continue;
            }

            if(isAscending) {
                if (arr[midIndex] < target) {
                    startIndex = midIndex + 1;
                } else {
                    endIndex = midIndex - 1;
                }
            } else {
                if (arr[midIndex] < target) {
                    endIndex = midIndex - 1;
                } else {
                    startIndex = midIndex + 1;
                }
            }
        }

        return targetIndex;
    }

    static int findInMountainArray(int target, int[] mountainArr) {
        int peakIndex = peakIndexInMountainArray(mountainArr);

        int lowerMinTargetIndex = findFirstInRange(mountainArr, target, 0, peakIndex);

        /* Case when the target is not found in the first half of the array */
        if (lowerMinTargetIndex == -1) {
            int higherMinTargetIndex;

            higherMinTargetIndex = findFirstInRange(
                    mountainArr,
                    target,
                    peakIndex,
                    (mountainArr.length - 1)
            );

            return higherMinTargetIndex;
        }

        return lowerMinTargetIndex;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 5, 9, 14, 14, 18, 21, 30, 25, 21, 17, 12, 8, 8, 2, 1 };
//        int[] arr = { 2, 5, 9, 9, 14, 12, 10, 10, 8, 2, 1 };
        int target = 8;
        int targetIndex = findInMountainArray(target, arr);
        System.out.println("Index of Target Element: " + targetIndex);
    }

}
