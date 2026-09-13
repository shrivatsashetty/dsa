/*

You have a set of integers `s`, which originally contains all the numbers from 1 to n.
Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set,
which results in repetition of one number and loss of another number.
You are given an integer array nums representing the data status of this set after the error.
Find the number that occurs twice and the number that is missing and return them in the form of an array.

Example 1:
Input: nums = [1,2,2,4]
Output: [2,3]
Example 2:

Example 2:
Input: nums = [1,1]
Output: [1,2]

Constraints:
2 <= nums.length <= 104
1 <= nums[i] <= 104

* */

package com.dsa.problems;

import java.util.Arrays;

public class SetMismatch {

    static void swapArrayElements(int[] arr, int sourceIndex, int targetIndex) {
        int buffer = arr[sourceIndex];
        arr[sourceIndex] = arr[targetIndex];
        arr[targetIndex] = buffer;
    }

    static void cyclicSort(int[] arr) {
        int i = 0;
        while(i < arr.length) {
            /* If the current element = currentIndex + 1, it's in position. Hence, we move on
             * If the current element is not is position, but its correct position is already occupied with the
             * same element (duplicate), then we move on to next element */
            if((arr[i] != i+1) && (arr[arr[i] - 1] != arr[i])) {
                swapArrayElements(arr, i, arr[i] - 1);
            }
            else {
                i++;
            }
        }
    }

    static int[] findErrorNums(int[] nums) {
        int N = nums.length;
        cyclicSort(nums);
        for (int i = 0; i < N; i++) {
            if ( nums[i] != i + 1) {
                return new int[]{nums[i], i+1};
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        /* The array elements should be consecutive numbers */
        int[] nums = {1,1};
        System.out.println("Given Array: " + Arrays.toString(nums));
        int[] errorNums = findErrorNums(nums);
        System.out.println("Missing Number: " + Arrays.toString(errorNums));
    }
}
