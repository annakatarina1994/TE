package com.techelevator.farm;

import java.math.BigDecimal;

public class Cow extends FarmAnimal implements Sellable, Product{
	// only extend from 1 class
	// implement as many interface as you want (separate by commas)

	public Cow() {
		super("Cow", "moo!");
	}

	@Override
	public BigDecimal getPrice() {
		return new BigDecimal("350.00");
	}

	@Override
	public BigDecimal getByProductCost() {
		return new BigDecimal ("3.50");
	}

	@Override
	public String getByProductName() {
		return "milk by gallon";
	}

}
