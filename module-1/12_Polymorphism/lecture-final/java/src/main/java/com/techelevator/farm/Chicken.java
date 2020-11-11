package com.techelevator.farm;

import java.math.BigDecimal;

public class Chicken extends FarmAnimal implements Product{

	public Chicken() {
		super("Chicken", "cluck!");
	}

	@Override
	public BigDecimal getByProductCost() {
		return new BigDecimal("1.99");
	}

	@Override
	public String getByProductName() {
		return "dozen eggs";
	}

}
