package com.dsa.examples;

import java.util.ArrayList;

public class ArrayList2D {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix1 = new ArrayList<>();
        int counter = 1;

        for (int i = 0; i < 3; i++) {
            matrix1.add(new ArrayList<>());
        }

        for(ArrayList<Integer> arrList: matrix1) {
            for (int i = 0; i < 3; i++) {
                arrList.add(counter);
                counter++;
            }
        }

        System.out.println(matrix1); // [[1, 2, 3], [4, 5, 6], [7, 8, 9]]


    }
}
