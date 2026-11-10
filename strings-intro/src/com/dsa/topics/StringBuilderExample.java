package com.dsa.topics;

public class StringBuilderExample {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            char c = (char)('A' + i);
            stringBuilder.append(c);
        }
        System.out.println(stringBuilder.toString()); // ABCDEFGHIJKLMNOPQRSTUVWXYZ
        System.out.println(stringBuilder.reverse()); // ZYXWVUTSRQPONMLKJIHGFEDCBA
    }
}
