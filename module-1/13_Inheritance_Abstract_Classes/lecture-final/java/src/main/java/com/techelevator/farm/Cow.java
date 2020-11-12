package com.techelevator.farm;

import java.math.BigDecimal;

public class Cow extends FarmAnimal  {


	public Cow() {
		super("Cow", "moo!");

	}

	@Override
	public void eat() {
		System.out.println("I eat grass and ruminate");
		
	}

}
