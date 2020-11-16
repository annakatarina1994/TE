package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class SameFirstLastTest {

	@Test
	public void isItTheSame_with_array_containing_4_5_4() {
		SameFirstLast firstLast = new SameFirstLast();
		int[] nums = {4, 5, 4};
		boolean actual = firstLast.isItTheSame(nums);
		assertTrue(actual);
	}
	
	@Test
	public void isItTheSame_with_array_containing_4_5_6_7() {
		SameFirstLast firstLast = new SameFirstLast();
		int[] nums = {4, 5, 6, 7};
		boolean actual = firstLast.isItTheSame(nums);
		assertFalse(actual);
	}
	
	@Test
	public void isItTheSame_with_empty_array() {
		SameFirstLast firstLast = new SameFirstLast();
		int[] nums = {};
		boolean actual = firstLast.isItTheSame(nums);
		assertFalse(actual);
	}

}
