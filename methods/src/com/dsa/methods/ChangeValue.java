package com.dsa.methods;

import java.util.Arrays;

public class ChangeValue {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4};
		changeVal(arr);
		System.out.println(Arrays.toString(arr));
	}

	static void changeVal(int[] array) {
		array[0] = 10;
	}
}
