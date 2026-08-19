package com.dsa.algorithms;
import java.util.Arrays;

public class BubbleSort {

    static void swapArrayElements(int[] arr, int sourceIndex, int targetIndex) {
        int buffer = arr[sourceIndex];
        arr[sourceIndex] = arr[targetIndex];
        arr[targetIndex] = buffer;
    }

    static void bubbleSort(int [] arr) {
        int indexEnd = arr.length - 1; // corresponds to the index of last element, it's where we start
        boolean swapped = true;
        while (swapped && indexEnd > 0) {
            swapped = false;
            for(int i = 0; i < indexEnd; i++ ) {
                if(arr[i] > arr[i + 1]) {
                    swapArrayElements(arr, i, i + 1);
                    swapped = true;
                }
            }
            indexEnd--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 8, 2};
        System.out.println("Initial Array: " + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("After Sorting: " + Arrays.toString(arr));
    }
}
