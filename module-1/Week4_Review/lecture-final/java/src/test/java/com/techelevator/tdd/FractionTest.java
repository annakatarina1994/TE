package com.techelevator.tdd;

import static org.junit.Assert.*;

import org.junit.Test;

public class FractionTest {

	@Test
	public void toString_for_1_half() {  // Fraction 1 2 => 1/2

		Fraction fraction = new Fraction(1, 2);
		String expected = "1/2";
		String actual = fraction.toString();
		assertEquals(expected, actual);
	}
	
	@Test
	public void toString_for_4_fifths() {
		Fraction fraction = new Fraction(4,5);
		assertEquals("4/5", fraction.toString());
	}
	@Test
	public void toString_for_2_thirds() {
		Fraction fraction = new Fraction(2,3);
		assertEquals("2/3", fraction.toString());
	}
	
	@Test
	public void multiply_1_half_times_1_half_returns_1_quarter() {
		Fraction f1 = new Fraction (1, 2);
		Fraction f2 = new Fraction (1, 2);
		
		Fraction actual = Fraction.multiply(f1, f2);
		assertEquals("1/4", actual.toString());
	}

	@Test
	public void multiply() {
		Fraction f1 = new Fraction (2, 5);
		Fraction f2 = new Fraction (1, 2);
		
		assertEquals("1/5", Fraction.multiply(f1, f2));
	}
}
