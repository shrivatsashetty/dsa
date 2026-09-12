package com.dsa.problems;

import java.util.Arrays;

public class DuplicateNumber {
    static void swapArrayElements(int[] arr, int sourceIndex, int targetIndex) {
        int buffer = arr[sourceIndex];
        arr[sourceIndex] = arr[targetIndex];
        arr[targetIndex] = buffer;
    }

    static void cyclicSort(int[] arr) {
        int i = 0;
        while(i < arr.length) {
            /* If the current element = currentIndex + 1, it's in position. Hence, we move on
             * If the current element is not is position, but it's correct position is already occupied with the
             * same element (duplicate), then we move on to next element */
            if((arr[i] != i+1) && (arr[arr[i] - 1] != arr[i])) {
                swapArrayElements(arr, i, arr[i] - 1);
            }
            else {
                i++;
            }
        }
    }

    static int findDuplicate(int[] nums) {
        int N = nums.length;
        cyclicSort(nums);
        // After the Cyclic Sort finishes, the duplicate number will have shifted to the last index of the array
        return nums[N - 1];
    }

    public static void main(String[] args) {
        /* The array elements should be consecutive numbers */
        int[] nums = {1, 3, 2, 2, 4};
        System.out.println("Given Array: " + Arrays.toString(nums));
        int duplicateNum = findDuplicate(nums);
        System.out.println("Duplicate Number: " + duplicateNum);
    }

}
