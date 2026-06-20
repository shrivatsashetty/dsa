package com.dsa.algorithm;

public class OrderAgnosticBinarySearch {
    static int binarySearchOrderAgnostic(int[] arr, int target) {

        int startIndex = 0;
        int endIndex = arr.length - 1;

        /* If first & the last elements are same,
        * then there's only one element in the array
        * or all elements are equal in the array */
        if(arr[startIndex] == arr[endIndex]) {
            return 0;
        }

        boolean isAscending = arr[startIndex] < arr[endIndex];


        while (startIndex <= endIndex) {

            // to prevent overflow of integer if start and end indices are too large
            int midIndex = startIndex + (endIndex - startIndex)/2;

            if(arr[midIndex] == target) {
                return midIndex;
            }

            if(isAscending) {
                if (arr[midIndex] < target) {
                    startIndex = midIndex + 1;
                } else {
                    endIndex = midIndex - 1;
                }
            } else {
                if (arr[midIndex] < target) {
                    endIndex = midIndex - 1;
                } else {
                    startIndex = midIndex + 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
//        int[] arr = {1, 4, 8, 14, 19, 21, 30};
        int[] arr = {25, 22, 17, 14, 7, 0, -1};
        int target = 17;
        int targetIndex = binarySearchOrderAgnostic(arr, target);
        System.out.println("Index of Target Element: " + targetIndex);
    }
}
