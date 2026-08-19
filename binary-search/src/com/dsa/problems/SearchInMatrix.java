/* Brute Force Algorithm to search for a given element in a 2D array */

package com.dsa.problems;

import com.dsa.algorithm.BinarySearch;
import java.util.Arrays;


public class SearchInMatrix {

    static int[] mapIndexToCoordinates(int index, int numCols) {
        if(index <= 0) {
            return new int[]{0,0};
        }
        else {
            int indexRow = index/numCols;
            int indexCol = index % numCols;
            return new int[]{indexRow, indexCol};
        }
    }

    /* Note that this method doesn't work for Jagged Arrays
     * In this example we consider the input to be a standard 2D matrix
     * TODO: Make this method compatible with Jagged Arrays as well */
    static int[] flattenArray(int[][] matrix) {

        int totalElements = matrix.length * matrix[0].length;
        int[] flattenedArray = new int[totalElements];
        int currentIndex = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                flattenedArray[currentIndex] = matrix[i][j];
                currentIndex++;
            }
        }

        return flattenedArray;
    }

    static int[] searchInMatrix(int[][] matrix, int target) {
        int[] flattenedArray = flattenArray(matrix);

        int targetIndex = BinarySearch.binarySearch(flattenedArray, target);
        return mapIndexToCoordinates(targetIndex, matrix[0].length);
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int target = 8;

        int[] coordinates = searchInMatrix(matrix, target);
        System.out.println("Target Coordinates " + Arrays.toString(coordinates));
    }

}
