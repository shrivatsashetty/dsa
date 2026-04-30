package com.dsa.problems;

public class EvenDigits {
    /* A method that returns the no of digits in an Integer
    * returns a non-negative integer denoting the no of digits in the given int number */
    static int getDigitCount(int num) {
        // convert negative integers to positive
        if (num < 0) {
            num *= -1;
        }

        // since 0 contains one digit
        if (num == 0) {
            return 1;
        }

        int counter = 0;

        while (num != 0) {
            num /= 10;
            counter++;
        }

        return counter;

    }

    /* A method to check of a number contains even no of digits
    * returns true if the no of digits contained in the number is true, false otherwise */
    static boolean isDigitCountEven(int num) {
        return getDigitCount(num) % 2 == 0;
    }

    public static void main(String[] args) {
        int[] nums = {21, 9, 123, 4444, 35, 0};

        int counter = 0;

        for (int num : nums) {
            if (isDigitCountEven(num)) {
                counter++;
            }
        }

        System.out.println(counter);
    }
}
