package com.techelevator.farm;

import java.math.BigDecimal;

public class Tractor implements Singable  {

	@Override
	public String getName() {		
		return "Tractor";
	}

	@Override
	public String getSound() {	
		return "vroom!";
	}
	
	public BigDecimal getPrice() {
		return (new BigDecimal("55000"));
	}

}
