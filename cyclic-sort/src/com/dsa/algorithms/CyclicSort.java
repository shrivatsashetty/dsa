package com.dsa.algorithms;

import java.util.Arrays;

public class CyclicSort {

    static void swapArrayElements(int[] arr, int sourceIndex, int targetIndex) {
        int buffer = arr[sourceIndex];
        arr[sourceIndex] = arr[targetIndex];
        arr[targetIndex] = buffer;
    }

    static void cyclicSort(int[] arr, int rangeStart) {
        int i = 0;
        while(i < arr.length) {
            int correctedIndex = Math.abs(arr[i] - rangeStart);

            if(correctedIndex == i) {
                i++;
            }
            else {
                swapArrayElements(arr, i, correctedIndex);
            }
        }
    }

    public static int getMinimum(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array must not be empty or null");
        }

        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        /* The array elements should be consecutive numbers */
        int[] nums = {-2, -1, 1, 0, 2, -3};
        System.out.println("Array Before Sort: " + Arrays.toString(nums));
        int arrMin = getMinimum(nums);
        cyclicSort(nums, arrMin);
        System.out.println("Array After Sort: " + Arrays.toString(nums));
    }
}
