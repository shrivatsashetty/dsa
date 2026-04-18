package com.dsa.arrays;

public class JaggedArrayExample {
    public static void main(String[] args) {

        /* Create a Jagged Array of two sub arrays of varying length */
        int[][] jaggedArray1 = new int[2][];

        /* Now specify the length of each sub-array in the Jagged Array */
        jaggedArray1[0] = new int[2];
        jaggedArray1[1] = new int[3];

        // populate array elements
        jaggedArray1[0][0] = 1;
        jaggedArray1[0][1] = 2;
        jaggedArray1[1][0] = 3;
        jaggedArray1[1][1] = 4;
        jaggedArray1[1][2] = 5;

        System.out.println(jaggedArray1[1][0]); // 3
        System.out.println();

        /* Create a jagged array using array literals */
        int[][] jaggedArray2 = new int[][] {
                {1, 2, 3},
                {4, 5},
                {6, 7, 8, 9}
        };

        /* printing elements of the Jagged Array
         * using enhance for loop */
        for (int[] arr : jaggedArray2) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }



    }
}
