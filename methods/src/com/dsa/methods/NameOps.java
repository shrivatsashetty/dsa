package com.dsa.methods;

public class NameOps {

    public void changeName(String someName) {
        someName = "Rahul";
    }

    public void mutateString() {
        String name1 = "Shri";
        String name2 = "Shri";
        System.out.println("Before Change");
        System.out.println("name1: " + name1);
        System.out.println("name2: " + name2);

        name2 = "Hari";
        System.out.println("After Change");
        System.out.println("name1: " + name1);
        System.out.println("name2: " + name2);

    }

}
