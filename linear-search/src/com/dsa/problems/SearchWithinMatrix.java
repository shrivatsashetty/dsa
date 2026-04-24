package com.dsa.problems;

import java.util.Arrays;

public class SearchWithinMatrix {
    static int[] search(int[][] twoDimensionalArray, int target) {
        if(twoDimensionalArray.length == 0)
            return new int[]{-1, -1};

        for (int indexRow = 0; indexRow < twoDimensionalArray.length; indexRow++) {
            for (int indexCol = 0; indexCol < twoDimensionalArray[indexRow].length; indexCol++) {
                if(twoDimensionalArray[indexRow][indexCol] == target) {
                    return new int[]{indexRow, indexCol};
                }
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[][] twoDimArray = {
                {34, 4, 1},
                {14, 2, 8, 9},
                {11, 7}
        };

        int target = 9;

        int[] indexTarget = search(twoDimArray, target);

        String resultText = """
                The target element: %d
                Occurs at index: %s
                """.formatted(target, Arrays.toString(indexTarget), Arrays.toString(twoDimArray));

        System.out.println(resultText);
    }
}
