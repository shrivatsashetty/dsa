package com.dsa.algorithm;

import java.util.Arrays;

public class InsertionSort {
    static void swapArrayElements(int[] arr, int sourceIndex, int targetIndex) {
        int buffer = arr[sourceIndex];
        arr[sourceIndex] = arr[targetIndex];
        arr[targetIndex] = buffer;
    }

    static void insertionSort(int[] arr) {
        // Run outer loop up to arr.length (inclusive of the last element)
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while ((j > 0) && (arr[j] < arr[j - 1])) {
                swapArrayElements(arr, j, j - 1);
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {10, 20, 5, 7, 6};
        System.out.println("Array Before Sort: " + Arrays.toString(nums));
        insertionSort(nums);
        System.out.println("Array After Sort: " + Arrays.toString(nums));
    }

}
