package com.dsa.problems;

public class PalindromeString {
    static boolean isStringPalindrome(String str) {
        str = str.toLowerCase();
        int idxStart = 0;
        int idxEnd = str.length() - 1;

        while (idxStart <= idxEnd) {
            if (str.charAt(idxStart) != str.charAt(idxEnd)) {
                return false;
            }
            idxStart++;
            idxEnd--;
        }

        return true;
    }

    public static void main(String[] args) {
        String text = "abcdefgfedcba";
        boolean isPalindrome = isStringPalindrome(text);
        System.out.println(isPalindrome);
    }
}
