package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class Less20Test {

	@Test
	public void isLessThanMultipleOf20_with_99_passed_through() {
		Less20 less20 = new Less20();
		int n = 99;
		boolean actual = less20.isLessThanMultipleOf20(n);
		assertTrue(actual);
	}
	
	@Test
	public void isLessThanMultipleOf20_with_198_passed_through() {
		Less20 less20 = new Less20();
		int n = 198;
		boolean actual = less20.isLessThanMultipleOf20(n);
		assertTrue(actual);
				
	}
	
	@Test
	public void isLessThanMultipleOf20_with_170_passed_through() {
		Less20 less20 = new Less20();
		int n = 170;
		boolean actual = less20.isLessThanMultipleOf20(n);
		assertFalse(actual);
	}

}
