package com.dsa.problems;

import java.util.Arrays;

public class SearchInSortedMatrix {

    /* A helper method to map an index of an array to a coordinate in a matrix */
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

    /* A modified version of the binary search algorithm to search for an element in a Matrix(2D Array) */
    static int[] binarySearchInMatrix(int[][] matrix, int target) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;

        int indexStart = 0;
        int indexEnd = (numRows * numCols) - 1;

        while (indexStart <= indexEnd) {
            int indexMid = indexStart + (indexEnd - indexStart)/2;

            // map the midIndex to actual coordinates in the matrix
            int[] coordinatesMid = mapIndexToCoordinates(indexMid, numCols);
            int indexMidRow = coordinatesMid[0];
            int indexMidCol = coordinatesMid[1];

            if(matrix[indexMidRow][indexMidCol] == target) {
                return coordinatesMid;
            } else if (matrix[indexMidRow][indexMidCol] < target) {
                indexStart = indexMid + 1;
            } else {
                // case when matrix[indexMidRow][indexMidCol] > target
                indexEnd = indexMid - 1;
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {3, 4, 7, 9},
                {12, 13, 16, 18},
                {20, 21, 23, 29},
        };

        int target = 21;

        int[] coordinates = binarySearchInMatrix(matrix, target);
        System.out.println("Target Coordinates " + Arrays.toString(coordinates));
    }
}
