package com.techelevator;

public class Calculator {
	
	public int add(int a, int b) {
		return (a + b);
	}
	
	//overloading by providing a new version
	public double add(double a, double b) {
		return (a + b);
	}
	
	//Overriding would provide a different 
	// version of a method than the parent's
	// version

}
