package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		System.out.println("Please enter a series of decimal numbers separated by spaces: ");
		Scanner input = new Scanner(System.in);
		String decimalNumsInput = input.nextLine();
		String[] decimalNums = decimalNumsInput.split(" ");
		
		for(int i = 0; i < decimalNums.length; i++) {
			int decimalNum = Integer.parseInt(decimalNums[i]);
			String binaryNum = Integer.toBinaryString(decimalNum);
			System.out.println(decimalNum + " in binary is " + binaryNum);
		}
	}

}
