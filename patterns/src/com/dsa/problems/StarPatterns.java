package com.dsa.problems;

public class StarPatterns {
    public static void main(String[] args) {
//        pattern1(5);
//        System.out.println("----------------------");
//        pattern2(5);
        System.out.println("----------------------");
        pattern3(4);

    }

    static void pattern1(int num) {
        for (int row = num; row > 0 ; row--) {
            for (int j = 0; j < row; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern2(int num) {
        for (int row = 1; row <= num ; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    static void pattern3(int peak) {

        int NUM_ROWS = (2 * peak) - 1;
        int idxRow = 1;
        int numStars = 1;

        while (idxRow <= NUM_ROWS) {
            for (int i = 1; i <= numStars; i++) {
                System.out.print("* ");
            }
            System.out.println();

            idxRow++;

            if (idxRow > peak) {
                numStars--;
            }
            else {
                numStars++;
            }

        }

    }

}
