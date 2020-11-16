package com.techelevator.crm;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class PetTest {

	@Test
	public void create_new_pet_named_bob_of_type_cat() {
		Pet bob = new Pet("Bob", "cat");
		
		String expectedName = "Bob";
		String expectedSpecies = "cat";
		
		String actualName = bob.getName();
		String actualSpecies = bob.getSpecies();
		
		assertEquals(expectedName, actualName);
		assertEquals(expectedSpecies, actualSpecies);
	}
	
	@Test
	public void listVaccinations_returns_Rabies_and_Parvo() {
		Pet bob = new Pet("Bob", "Cat");
		List<String> vaccinations = new ArrayList<>(Arrays.asList("Rabies",
				"Parvo"));
		bob.setVaccinations(vaccinations);
		
		String expectedVaccinationsList = "Rabies, Parvo";
		String actualVaccinationsList = bob.listVaccinations();
		
		assertEquals(expectedVaccinationsList, actualVaccinationsList);
	}

}
