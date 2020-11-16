package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnimalGroupNameTest {

	@Test
	public void getHerd_with_lion_passed_through() {
		AnimalGroupName groupName = new AnimalGroupName();
		String lion = "Lion";
		String expected = "Pride";
		String actual = groupName.getHerd(lion);
		assertEquals(expected, actual);
	}

}
