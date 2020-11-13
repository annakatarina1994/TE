package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class FrontTimesTest {

	@Test
	public void generateString_with_word_potato_7_times() {
		FrontTimes frontTimes = new FrontTimes();
		String potato = "Potato";
		int n = 7;
		String expected = "PotPotPotPotPotPotPot";
		String actual = frontTimes.generateString(potato, n);
		assertEquals(expected, actual);
	}
	
	@Test
	public void generateString_with_word_na_3_times() {
		FrontTimes frontTimes = new FrontTimes();
		String na = "na";
		int n = 3;
		String expected = "nanana";
		String actual = frontTimes.generateString(na, n);
		assertEquals(expected, actual);
		}

}
