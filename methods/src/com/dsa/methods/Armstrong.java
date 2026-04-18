/* A Java program to get all the 3 digit Armstrong no's  */

package com.dsa.methods;

import java.util.ArrayList;

public class Armstrong {

	/**
	 * Check if a number is Armstrong or not
	 * 
	 * @param number
	 * @return true if the number is armstrong, false otherwise
	*/
	public static boolean isArmstrong(int number) {

		int originalNumber, remainder, result = 0;

		originalNumber = number;

		while (originalNumber != 0) {
			remainder = originalNumber % 10;
			result += Math.pow(remainder, 3);
			originalNumber /= 10;
		}

		if (result == number)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {

		ArrayList<Integer> armstrongNums = new ArrayList<Integer>(); // Create an ArrayList object

		// we start the iteration with 100 since it is the smallest 3 digit number
		for(int i = 100; i < 1000; i++) {
			if(isArmstrong(i)) {
				armstrongNums.add(i);
			}
		}

		System.out.println(armstrongNums);
	}
}
