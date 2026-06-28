
/* This is a slightly different solution for the problem in `NextGreatestLetter.java`
 * This one makes use of Modulo operator to wrap the result and prevent ArrayIndexOutOfBounds exception
 * Even though the solution within `NextGreatestLetter.java` is simpler to understand & faster than this,
 * this solution is a bit more concise */

package com.dsa.problems;

public class NextGreatestLetterAlternate {
    public static char nextGreatestLetter(char[] letters, char target) {

        int startIndex = 0;
        int endIndex = letters.length - 1;

        while (startIndex <= endIndex) {

            // to prevent overflow of integer if start and end indices are too large
            int midIndex = startIndex + (endIndex - startIndex)/2;

            if ((letters[midIndex] > target)) {
                endIndex = midIndex - 1;
            } else {
                startIndex = midIndex + 1;
            }
        }

        return letters[startIndex % letters.length];
    }

    public static void main(String[] args) {
        char[] letters = { 'e', 'e', 'n' };
        char target = 'e';
        char answer = nextGreatestLetter(letters, target);
        System.out.println("Answer: " + answer);
    }
}
