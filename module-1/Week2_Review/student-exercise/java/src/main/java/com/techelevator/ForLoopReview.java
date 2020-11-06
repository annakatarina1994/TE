package com.techelevator;

import java.util.Collections;
import java.util.Scanner;

public class ForLoopReview {

	public static void main(String[] args) {
		
		int[] intArray = new int[10];
		Scanner userInput = new Scanner(System.in); //Scanner() calling the constructor
		
		for(int i = 0; i < intArray.length; i++) {
			System.out.println("Enter in number " + (i + 1));
			String intStr = userInput.nextLine(); //gets user input as a string
			intArray[i] = Integer.parseInt(intStr); //converts string to int and loads into the array
			//two above lines can be combined into:
			// intArray[i] = Integer.parseInt(userInput.nextLine());
 		}
		
		System.out.println("The elements in the array are: ");
		for(int num : intArray) { //inside we use num to refer to each element in the intArray
			System.out.println(num + " ");
			
		}
		
		int min = intArray[0]; // priming read loads loads valid data into variable
		int max = intArray[0];
		int sum = 0;
		
		for( int i = 1; i < intArray.length; i++) {
			if(intArray[i] < min) {
				min = intArray[i];
			}
			if(intArray[i]  > max) {
				max = intArray[i];
			}
			sum += intArray[i];
		}
		System.out.println("\nThe smallest number is: " + min);
		System.out.println("\nThe largest number is: " + max);
		
		double avg = (double)sum / intArray.length;
		System.out.println("The average is: " + avg);
		
	}

}
