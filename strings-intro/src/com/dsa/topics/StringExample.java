package com.dsa.topics;

public class StringExample {
    public static void main(String[] args) {
        String name1 = "Shri";
        String name2 = "Shri";

        System.out.println("Name 1:" + name1); // Shri
        System.out.println("Name 2:" + name2); // Shri

        System.out.println("name1 == name2: " + (name1 == name2)); // true
        System.out.println("name1.equals(name2): " + name1.equals(name2)); // true

        name2 = "Vatsa";

        System.out.println("After Name 2 value changed:");
        System.out.println("Name 1:" + name1); // Shri
        System.out.println("Name 2:" + name2); // Vatsa

        System.out.println("name1 == name2: " + (name1 == name2)); // false
        System.out.println("name1.equals(name2): " + name1.equals(name2)); // false

        System.out.println("Using the String Constructor:");

        String str1 = new String("Hello");
        String str2 = new String("Hello");

        System.out.println("str1:" + str1); // Hello
        System.out.println("str2:" + str2); // Hello

        System.out.println("str1 == str2: " + (str1 == str2)); // false, compares memory addresses of the string objs
        System.out.println("str1.equals(str2): " + str1.equals(str2)); // true, compares only literal values

    }
}
