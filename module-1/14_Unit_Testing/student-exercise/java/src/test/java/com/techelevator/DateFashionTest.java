package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class DateFashionTest {

	@Test
	public void getATable_with_you_as_9_and_date_as_1() {
		DateFashion style = new DateFashion();
		int you = 9;
		int date = 1;
		int expected = 0;
		int actual = style.getATable(you, date);
		assertEquals(expected, actual);
	}
	
	@Test
	public void getATable_with_you_as_5_and_date_as_5() {
		DateFashion style = new DateFashion();
		int you = 5;
		int date = 5;
		int expected = 1;
		int actual = style.getATable(you, date);
		assertEquals(expected, actual);
	}
	
	@Test
	public void getATable_with_you_as_4_and_date_as_9() {
		DateFashion style = new DateFashion();
		int you = 4;
		int date = 9;
		int expected = 2;
		int actual = style.getATable(you, date);
		assertEquals(expected, actual);
	}

}
