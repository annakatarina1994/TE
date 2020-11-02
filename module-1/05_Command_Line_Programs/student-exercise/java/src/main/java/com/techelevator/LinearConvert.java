package com.techelevator;

import java.util.Scanner;

public class LinearConvert {
	
//	meters = feet * 0.3048
//	feet = meters * 3.2808399

	public static void main(String[] args) {
		System.out.println("Please enter a length in either feet or meters: ");
		Scanner input = new Scanner(System.in);
		String lengthInput = input.nextLine();
		
		System.out.println("Is this length in feet or meters? Enter F or M: ");
		String lengthType = input.nextLine();
		
		if(lengthType.equals("F")) {
			double lengthInputF = Double.parseDouble(lengthInput);
			double lengthInMeters = lengthInputF * 0.3048;
			System.out.println(lengthInputF + " feet is " + String.format("%.2f", lengthInMeters) + " meters.");
		} else if(lengthType.equals("M")) {
			double lengthInputM = Double.parseDouble(lengthInput);
			double lengthInFeet = lengthInputM * 3.2808399;
			System.out.println(lengthInputM + " meters is " + String.format("%.2f", lengthInFeet) + " feet.");
		}
	}

}
