package com.dsa.problems;

public class ArrayOps {

    public void swapArrayElements(int[] arr, int index1, int index2) {
        int buffer = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = buffer;
    }

    public int getMax(int[] arr) {
        int max = arr[0];

        /* Iteration using
         * enhanced for loop */
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public void reverse(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while(start < end) {
            swapArrayElements(arr, start, end);
            start++;
            end--;
        }
    }
}
