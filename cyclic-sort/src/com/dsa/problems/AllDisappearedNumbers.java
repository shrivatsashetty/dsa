package com.dsa.problems;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class AllDisappearedNumbers {

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

    /* Made public to match signature of function as per Leet-code problem */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missingNums = new ArrayList<>();
        int N = nums.length;
        cyclicSort(nums);
        for (int i = 0; i < N; i++) {
            if (i != nums[i] - 1) {
                missingNums.add(i + 1);
            }
        }
        return missingNums;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println("Given Array: " + Arrays.toString(nums));
        List<Integer> missingNumbers = new AllDisappearedNumbers().findDisappearedNumbers(nums);
        System.out.println("Missing Number: " + missingNumbers);
    }
}
