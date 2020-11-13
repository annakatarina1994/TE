package com.techelevator;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;


public class CalculatorTest {
	Calculator calc;
	
	@BeforeClass
	public void setUp() {
		calc = new Calculator();
	}

	@Test
	public void add_method_adds_42_and_23_returns_65() {
		Calculator calc = new Calculator(); // arrange
		int a = 42;
		int b = 23;
		int actual = calc.add(a, b); //Action
		int expected = 65;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void add_method_adds_42_5_and_23_2_returns_65_7(){
		Calculator calc = new Calculator();
		double a = 42.5;
		double b = 23.2;
		double actual = calc.add(a, b);
		double expected = 65.7;
		double delta = 0.0000001; //how much < or > can the actual be from the expected
								//and still be considered equal?
		assertEquals(expected, actual, delta);
	}

}
