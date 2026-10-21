/*
Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

Example 1:
Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.

Example 2:
Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.

Example 3:
Input: nums = [7,8,9,11,12]
Output: 1
Explanation: The smallest positive integer 1 is missing.

Constraints:
1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1

* */

package com.dsa.problems;

public class FirstMissingPositive {

    static void swapArrayElements(int[] arr, int sourceIndex, int targetIndex) {
        int buffer = arr[sourceIndex];
        arr[sourceIndex] = arr[targetIndex];
        arr[targetIndex] = buffer;
    }

    static int getSmallestPositive(int[] arr) {

        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be empty or null");
        }

        int smallestPositive = Integer.MAX_VALUE; // returns (2^31) - 1, the max value that can be stored by integer

        // iterating the array using an enhanced for loop
        for (int num : arr) {
            if (num > 0 && num < smallestPositive) {
                smallestPositive = num;
            }
        }

        return smallestPositive;
    }

    static void cyclicSort(int[] arr, int smallestPositive) {
        int i = 0;

        while(i < arr.length) {
            // variable `i` is the current index under iteration
            int correctedIndex = arr[i] - smallestPositive;

            /* We Skip Swapping the Array elements in the following scenarios:
             * 1. If the calculated correctIndex is out of Array bounds
             *      i.e. less than 0 and greater than length of array
             * 2. If the current element is already in the correct index
             * 3. If the element is not in its correct index, but there's already a duplicate of the current element
             *      present at the correct index  */
            if(correctedIndex >= arr.length || correctedIndex < 0 || arr[correctedIndex] == arr[i]) {
                i++;
                continue;
            }

            swapArrayElements(arr, i, correctedIndex);
        }
    }

    static int firstMissingPositive(int[] nums) {

        int smallestPositive = getSmallestPositive(nums);

        /* If the `getSmallestPositive` method returns -1,
         * It means there are no positive integers in the array,
         * Hence we can directly return 1 */
        if (smallestPositive < 0) {
            return 1;
        }

        cyclicSort(nums, smallestPositive);

        int smallestMissingPositive = 1;

        // Using Enhanced for loop to iterate over each number in the array
        for (int num : nums) {
            if (num != smallestMissingPositive || num < 1) {
                return smallestMissingPositive;
            }
            smallestMissingPositive++;
        }
        return smallestMissingPositive;
    }

    public static void main(String[] args) {
        /* The array elements should be consecutive numbers */
        int[] nums = {-10,	1,	2,	2,	3,	4,	6,	6,	8};
        int smallestMissingPositive = firstMissingPositive(nums);
        System.out.println("First/Smallest Missing Positive: " + smallestMissingPositive);
    }

}
