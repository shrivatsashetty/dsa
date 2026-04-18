package com.dsa.problems;

import java.util.Arrays;

public class ReverseAnArray {
    public static void main(String[] args) {

        ArrayOps arrayOps = new ArrayOps();

        int[] nums = {1, 2, 3, 4, 5};

        arrayOps.reverse(nums);

        System.out.println(Arrays.toString(nums));
    }
}
