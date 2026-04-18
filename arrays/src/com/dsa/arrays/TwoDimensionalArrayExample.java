package com.dsa.arrays;

import java.util.Arrays;

public class TwoDimensionalArrayExample {
    public static void main(String[] args) {

        /* Initialization Phase,
         * A reference is created but no memory is allocated  */
        int[][] matrix1;

        /* Memory Allocation Phase,
         * Use the new keyword to create the array object and specify its dimensions. 
         * This step reserves space in memory.  */
        matrix1 = new int[2][2];
        
        /* Assignment of values */
        matrix1[0][0] = 1;
        matrix1[0][1] = 2;
        matrix1[1][0] = 3;
        matrix1[1][1] = 4;

        /* The array will store reference (memory address) to the inner array objects  */
        System.out.println(matrix1.length); // 2
        System.out.println(Arrays.toString(matrix1)); // [[I@15aeb7ab, [I@7b23ec81]

        /* The first element of the array actually stores the Array object  */
        System.out.println(matrix1[0].length); // 2
        System.out.println(Arrays.toString(matrix1[0])); // [1, 2]

        /* Creating an Array via direct assignment */
        int[][] matrix2 = new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println(matrix2.length);
        System.out.println(Arrays.toString(matrix1));
        System.out.println(Arrays.toString(matrix2[0]));


    }
}
