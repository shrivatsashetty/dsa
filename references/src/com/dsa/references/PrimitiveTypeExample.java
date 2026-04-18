package com.dsa.references;

public class PrimitiveTypeExample {
	public static void main(String[] args) {

	    int a = 10;
	    int b = a;
		System.out.println("Before Change:");
		System.out.println("a = " + a); // 10
		System.out.println("b = " + b); // 10
		
		b = 20;
		
		System.out.println("After Change:");
		System.out.println("a = " + a); // 10
		System.out.println("b = " + b); // 20
	}
}
