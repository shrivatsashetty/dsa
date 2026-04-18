package com.dsa.methods;

public class VarArgs {
	public static void main(String[] args) {

		int sum1 = sum(1,2);
		System.out.println(sum1); // 3

		int sum2 = sum(1,2, 3, 4);
		System.out.println(sum2); // 10

	}

	static int sum(int a, int b, int ...nums) {
		int total = 0;
		total = a + b;
		
		// summation using enhanced for loop
		for (int num : nums) {
    		total += num;
		}
		return total;
	}
}
