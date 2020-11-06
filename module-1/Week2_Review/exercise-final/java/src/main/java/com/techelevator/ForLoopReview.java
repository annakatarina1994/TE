package com.techelevator;

import java.util.Scanner;

public class ForLoopReview {

	public static void main(String[] args) {

		int[] intArray = new int[10];
		Scanner userInput = new Scanner(System.in); // Scanner(System.in) -- calling the constructor passing in 1
													// argument

		for (int i = 0; i < intArray.length; i++) {
			System.out.print("Enter in number " + (i + 1) + ": ");
			String intStr = userInput.nextLine(); // gets the user input as a string
			intArray[i] = Integer.parseInt(intStr); // converts the intStr to an integer and loads into the array
			// two above lines can be combined into
			// intArray[i] = Integer.parseInt(userInput.nextLine());
		}
		System.out.println("The elements in the array are: ");
		for (int num : intArray) {
			// inside we use number to refer to each element in the intArray
			System.out.print(num + " ");
		}
		int min = intArray[0]; // priming read loads valid data into variable
		int max = intArray[0];
		int sum = 0;

		for (int i = 0; i < intArray.length; i++) {
			if (intArray[i] < min) {
				min = intArray[i];
			}
			if (intArray[i] > max) {
				max = intArray[i];
			}
			sum += intArray[i];
		}
		System.out.println("\n\nThe smallest number is: " + min);
		System.out.println("The largest number is: " + max);

		double avg = (double) sum / intArray.length;
		System.out.println("The average is: " + avg);

	}

}
