package com.techelevator;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class WordCountTest {

	@Test
	public void add_one_word_get_one_back() {
		WordCount wordCount = new WordCount();
		
		Map<String, Integer> expected = new HashMap<>();
		expected.put("Bob", 1);
		
		String[] words = {"Bob"};
		Map<String, Integer> actual = wordCount.getCount(words);
		assertEquals(expected, actual);
	}

	
	@Test
	public void add_one_word_twice_get_value_of_2_back() {
		WordCount wordCount = new WordCount();
		
		Map<String, Integer> expected = new HashMap<>();
		expected.put("Flo", 2);
		
		String[] words = {"Flo", "Flo"};
		Map<String, Integer> actual = wordCount.getCount(words);
		assertEquals(expected, actual);
	}
}
