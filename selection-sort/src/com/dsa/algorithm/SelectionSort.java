package com.dsa.algorithm;

import java.util.Arrays;

public class SelectionSort {
    static void swapArrayElements(int[] arr, int sourceIndex, int targetIndex) {
        int buffer = arr[sourceIndex];
        arr[sourceIndex] = arr[targetIndex];
        arr[targetIndex] = buffer;
    }

    /* A helper function to get the maximum element from the given array */
    static int getMaxElementWithinRange(int[] arr, int start, int end) {

        /* Check for validity of start & end range */
        if(start > end || start < 0 || end > (arr.length - 1) ) {
            return 0;
        }

        int indexMaxElement = start; // let's start off with the first element as the max element

        for (int i = start; i <= end; i++) {
            if(arr[i] > arr[indexMaxElement]) {
                indexMaxElement = i;
            }
        }

        return indexMaxElement;
    }

    /* The Selection Sort Algorithm does not return anything but sorts the array in-place   */
    static void selectionSort(int[] arr) {
        int indexEnd = arr.length - 1;

        while(indexEnd > 0) {
            int indexMaxElement = getMaxElementWithinRange(arr, 0, indexEnd);
            swapArrayElements(arr, indexMaxElement, indexEnd);
            indexEnd--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-4, -2, 5, 9, -5, 7, 10};
        System.out.println("Array Before Sort: " + Arrays.toString(nums));
        selectionSort(nums);
        System.out.println("Array After Sort: " + Arrays.toString(nums));
    }

}
