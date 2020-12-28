package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class CarTest {

	@Test
	public void ageGetter_calculates_age_correctly() {
		Car testCar = new Car(2010, "Nissan", false);
		int testAge = 10;
		int actualAge = testCar.getAge(2020);
		assertEquals(testAge, actualAge);
	}
	
	@Test
	public void carNeedsECheck_returns_false_if_car_isClassic() {
		Car testCar = new Car(1950, "Chevy", true);
		boolean actualIsItClassic = testCar.carNeedsECheck(2020);
		assertFalse(actualIsItClassic);
	}

	@Test
	public void carNeedsECheck_returns_true_if_year_and_yearToCheck_are_both_odd() {
		Car testCar = new Car(2001, "Nissan", false);
		boolean carShouldBeChecked = testCar.carNeedsECheck(2017);
		assertTrue(carShouldBeChecked);
	}
	
	@Test
	public void carNeedsECheck_returns_false_if_age_is_less_than_four() {
		Car testCar = new Car(2019, "Nissan", false);
		boolean carDoesntNeedCheck = testCar.carNeedsECheck(2020);
		assertFalse(carDoesntNeedCheck);
	}
}
