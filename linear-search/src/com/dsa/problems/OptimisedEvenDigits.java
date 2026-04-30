package com.dsa.problems;

public class OptimisedEvenDigits {

    /* A method to get the count of digits in a given number
     * using Base 10  Logarithm */
    static int getDigitCount(int num) {

        // if the no is 0 return 1 since 0 contains 1 digit
        if (num == 0) {
            return 1;
        }

        // Convert any negative integer to positive
        if (num < 0) {
            num *= -1;
        }

        int numDigits = (int)Math.log10(num) + 1;

        return numDigits;
    }

    static boolean isDigitCountEven(int num) {
        return getDigitCount(num) % 2 == 0;
    }

    public static void main(String[] args) {
        int num = 231;
        int numDigits = getDigitCount(297);
        System.out.println(numDigits);
    }
}
