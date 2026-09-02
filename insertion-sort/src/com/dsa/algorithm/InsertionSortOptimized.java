package com.dsa.algorithm;

import java.util.Arrays;

public class InsertionSortOptimized {

    /* This specific algorithm is more optimized
     * since it continuously shifts the elements greater than the key (the target element), one place to right.
     * rather than continuously swapping them with the key */
    static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] nums = {10, 20, 5, 7, 6};
        System.out.println("Array Before Sort: " + Arrays.toString(nums));
        insertionSort(nums);
        System.out.println("Array After Sort: " + Arrays.toString(nums));
    }
}
