package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringBitsTest {

	@Test
	public void getBits_() {
		StringBits everyOther = new StringBits();
		String str = "Random";
		String expected = "Rno";
		String actual = everyOther.getBits(str);
		assertEquals(expected, actual);
	}

}
