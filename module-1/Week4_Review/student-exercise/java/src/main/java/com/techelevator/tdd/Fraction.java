package com.techelevator.tdd;

public class Fraction {
	
	/*
	 * Fraction class --
	 * add fractions together
	 * subtract
	 * multiply
	 * divide
	 * equal
	 * toString -- prints out the String representation of the Fraction
	 * simplify?
	 */
	
	private int numerator;
	private int denominator;
	
	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	@Override
	public String toString() {
		return numerator + "/" + denominator;
	}

	public static Fraction multiply(Fraction a, Fraction b) {
		int num = a.numerator * b.numerator;
		int den = a.denominator * b.denominator;
		Fraction answer = new Fraction(num, den);
		return answer;
	}
}
