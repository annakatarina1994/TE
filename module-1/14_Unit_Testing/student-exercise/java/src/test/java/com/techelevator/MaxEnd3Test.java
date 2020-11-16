package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaxEnd3Test {

	@Test
	public void makeArray_given_an_array_with_13_26_15() {
		MaxEnd3 maxEnd = new MaxEnd3();
		int[] nums = {13, 26, 15};
		int[] expected = {15, 15, 15};
		int[] actual = maxEnd.makeArray(nums);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void makeArray_given_an_array_with_8_12_8() {
		MaxEnd3 maxEnd = new MaxEnd3();
		int[] nums = {8, 12, 8};
		int[] expected = {8, 8, 8};
		int[] actual = maxEnd.makeArray(nums);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void makeArray_given_an_array_with_9_3_3() {
		MaxEnd3 maxEnd = new MaxEnd3();
		int[] nums = {9, 3, 3};
		int[] expected = {9, 9, 9};
		int[] actual = maxEnd.makeArray(nums);
		assertArrayEquals(expected, actual);
	}
	
}
