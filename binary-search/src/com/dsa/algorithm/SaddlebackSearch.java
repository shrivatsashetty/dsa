package com.dsa.algorithm;

import java.util.Arrays;

public class SaddlebackSearch {
    /**
     * Searches for a target value in an m x n matrix where rows and columns are sorted.
     *
     * @param matrix The 2D array to search within.
     * @param target The value to find.
     * @return An array containing {row, col} if found, or {-1, -1} if not found.
     */
    static int[] saddlebackSearch(int[][] matrix, int target) {

        // Edge Case: Check for null or empty matrices
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[] {-1, -1};
        }

        int m = matrix.length; // no of rows
        int n = matrix[0].length; // no of columns

        int i = 0;
        int j = n - 1;

        while (i < m && j >= 0) {
            if(matrix[i][j] == target) {
                return new int[]{i, j};
            }
            else if (matrix[i][j] > target) {
                j  = j - 1;
            }
            else {
                // case when matrix[i][j] < target
                i = i + 1;
            }
        }

        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1,  4,  7, 11, 15},
                { 2,  5,  8, 12, 19},
                { 3,  6,  9, 16, 22},
                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30}
        };

        int target = 10;
        int[] result = saddlebackSearch(matrix, target);

        System.out.println("Result coordinates: " + Arrays.toString(result));
    }

}
