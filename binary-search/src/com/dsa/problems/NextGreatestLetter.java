/*

You are given an array of characters `letters` that is sorted in non-decreasing order, and a character `target`.
There are at least two different characters in letters.

Return the smallest character in letters that is lexicographically greater than target.
If such a character does not exist, return the first character in letters.

Example 1:
Input: letters = ["c","f","j"], target = "a"
Output: "c"
Explanation: The smallest character that is lexicographically greater than 'a' in letters is 'c'.

Example 2:
Input: letters = ["c","f","j"], target = "c"
Output: "f"
Explanation: The smallest character that is lexicographically greater than 'c' in letters is 'f'.
Example 3:

Input: letters = ["x","x","y","y"], target = "z"
Output: "x"
Explanation: There are no characters in letters that is lexicographically greater than 'z' so we return letters[0].


Constraints:
2 <= letters.length <= 104
letters[i] is a lowercase English letter.
letters is sorted in non-decreasing order.
letters contains at least two different characters.
target is a lowercase English letter.

*/

package com.dsa.problems;

public class NextGreatestLetter {
    public static char nextGreatestLetter(char[] letters, char target) {

        /* If the `target` is greater than or equal the last character i.e. the greatest character in the array,
         * we consider this as "No Match" situation */
        if(target >= letters[letters.length - 1]) {
            return letters[0];
        }

        int startIndex = 0;
        int endIndex = letters.length - 1;

        while (startIndex <= endIndex) {

            // to prevent overflow of integer if start and end indices are too large
            int midIndex = startIndex + (endIndex - startIndex)/2;

            if ((letters[midIndex] <= target)) {
                startIndex = midIndex + 1;
            } else {
                endIndex = midIndex - 1;
            }
        }

        return letters[startIndex];
    }

    public static void main(String[] args) {
        char[] letters = { 'e', 'e', 'n' };
        char target = 'e';
        char answer = nextGreatestLetter(letters, target);
        System.out.println("Answer: " + answer);
    }
}
