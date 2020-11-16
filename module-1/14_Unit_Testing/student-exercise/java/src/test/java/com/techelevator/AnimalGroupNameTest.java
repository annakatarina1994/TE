package com.techelevator;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class AnimalGroupNameTest {

	@Test
	public void ill_think_of_a_method_name_in_a_sec() {
		AnimalGroupName animalGroupName = new AnimalGroupName();
		
		String animalName = "rhino";
		String expected = "Crash";
		String actual = animalGroupName.getHerd(animalName);
		assertEquals(expected, actual);
	}

}
