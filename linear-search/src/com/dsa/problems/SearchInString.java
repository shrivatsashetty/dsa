package com.dsa.problems;

import java.util.Arrays;

public class SearchInString {
    static int linearSearchWithingString(String source, char target) {

        // Check if Source String is empty ?
        if (source.isEmpty())
            return -1;

        for (int index = 0; index < source.length(); index++) {
            if(source.charAt(index) == target) {
                return index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String sourceStr = "Hello World!!";
        char targetChar = 'l';
        int indexTarget = linearSearchWithingString(sourceStr, targetChar);

        // Multiline string using text block in Java
        String resultText = """
                The targetChar element: '%c'
                Occurs at index: %d
                Withing the String: "%s"
                """.formatted(targetChar, indexTarget, sourceStr);

        System.out.println(resultText);
    }
}
