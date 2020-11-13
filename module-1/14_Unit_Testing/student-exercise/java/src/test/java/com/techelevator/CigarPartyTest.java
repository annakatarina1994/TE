package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class CigarPartyTest {

	@Test
	public void haveParty_with_10_cigars_and_not_isWeekend() {
		CigarParty party = new CigarParty();
		int cigars = 10;
		boolean isWeekend = false;
		boolean actual = party.haveParty(cigars, isWeekend);
		assertFalse(actual);
	}
	
	@Test
	public void haveParty_with_60_cigars_and_isWeekend() {
		CigarParty party = new CigarParty();
		int cigars = 70;
		boolean isWeekend = true;
		boolean actual = party.haveParty(cigars, isWeekend);
		assertTrue(actual);
	}

}
