/* Given a sorted array `arr[]` of infinite numbers. The task is to search for an element k in the array.

Examples:
Input: arr[] = [3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170, 188, 191, 199, 201, 220], k = 10
Output: 4
Explanation: 10 is at index 4 in array.

Input: arr[] = [2, 5, 7, 9], k = 3
Output: -1
Explanation: 3 is not present in array.

*/

package com.dsa.problems;

public class InfiniteArraySearch {
    static int search(int[] arr, int target) {

        int startIndex = 0;
        int endIndex = 1;
        int targetIndex = -1;

        while (arr[endIndex] < target) {
            startIndex = endIndex + 1;
            endIndex = endIndex * 2;
        }

        if (arr[endIndex] == target) {
            return endIndex;
        }

        targetIndex = binarySearch(arr, startIndex, endIndex, target);

        return targetIndex;
    }


    static int binarySearch(int[] arr, int startIndex, int endIndex, int target) {

        while (startIndex <= endIndex) {
            // to prevent overflow of integer if start and end indices are too large
            int midIndex = startIndex + (endIndex - startIndex)/2;

            if(arr[midIndex] == target) {
                return midIndex;
            } else if (arr[midIndex] < target) {
                startIndex = midIndex + 1;
            } else {
                // condition when: `arr[midIndex] > target` `
                endIndex = midIndex - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170, 188, 191, 199, 201, 220};
        int target = 10;
        int targetIndex = search(arr, target);
        System.out.println("Index of Target Element: " + targetIndex);
    }
}
