package com.techelevator;

public class Module1CodingAssessment {

	public static void main(String[] args) {
		Car viper = new Car(2000, "Dodge", false);
		Car oldCorvette = new Car(1957, "Chevy", true);
		
		System.out.println(viper.carNeedsECheck(2020));
		System.out.println(viper.toString());
	}

	
}
