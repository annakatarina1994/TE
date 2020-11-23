package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class MovieRentalTest {

	@Test
	public void getRentalPrice_given_VHS_should_return_zero_point_99() {
		MovieRental movie1 = new MovieRental("Test Movie", "VHS", false);
		double expected = 0.99;
		double actual = movie1.getRentalPrice();
		assertEquals(expected, actual, 0.001);
	}

	@Test
	public void getRentalPrice_given_DVD_and_premium_should_return_2_99() {
		MovieRental movie2 = new MovieRental("The Testers", "BluRay", true);
		double expected = 3.99;
		double actual = movie2.getRentalPrice();
		assertEquals(expected, actual, 0.001);
	}
}
