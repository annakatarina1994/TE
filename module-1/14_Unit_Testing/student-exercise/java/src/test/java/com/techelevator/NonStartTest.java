package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class NonStartTest {

	@Test
	public void getPartialString_with_drama_llama() {
		NonStart nonStart = new NonStart();
		String a = "drama";
		String b = "llama";
		String expected = "ramalama";
		String actual = nonStart.getPartialString(a, b);
		assertEquals(expected, actual);
	}

	@Test
	public void getPartialString_with_ab_cd(){
		NonStart nonStart = new NonStart();
		String a = "ab";
		String b = "cd";
		String expected = "bd";
		String actual = nonStart.getPartialString(a, b);
		assertEquals(expected, actual);
	}
	
	@Test
	public void getPartialString_with_just_bee_as_string_a() {
		NonStart nonStart = new NonStart();
		String a = "bee";
		String b = "";
		String expected = "ee";
		String actual = nonStart.getPartialString(a, b);
		assertEquals(expected, actual);
	}
	
	@Test
	public void getPartialString_with_just_poo_as_string_b() {
		NonStart nonStart = new NonStart();
		String a = "";
		String b = "poo";
		String expected = "oo";
		String actual = nonStart.getPartialString(a, b);
		assertEquals(expected, actual);
	}
	
}
