package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class Lucky13Test {

	@Test
	public void getLucky_with_an_array_that_does_not_contain_1_or_3() {
		Lucky13 lucky13 = new Lucky13();
		int[] nums = {2, 6, 10, 17, 9};
		boolean actual = lucky13.getLucky(nums);
		assertTrue(actual);
	}
	
	@Test
	public void getLucky_with_an_array_that_contains_1_and_3() {
		Lucky13 lucky13 = new Lucky13();
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
		boolean actual = lucky13.getLucky(nums);
		assertFalse(actual);
	}

}
