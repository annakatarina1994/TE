package com.techelevator;

public class Debugging {

	public static void main(String[] args) {
		int sum = 0;
		
		int[] array = { 5, 67, 42, 18, 5};
		
		for (int i = 0; i < array.length; ++i) {
			sum = sum + array[i]; // accumulator
		}
		
		System.out.println("The sum of the array is ");
	}

}
