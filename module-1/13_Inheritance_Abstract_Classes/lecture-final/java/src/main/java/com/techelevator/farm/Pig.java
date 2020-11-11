package com.techelevator.farm;

import java.math.BigDecimal;

public class Pig extends FarmAnimal {
   
    public Pig() {
        super("Pig", "oink!");

    }

	@Override
	public void eat() {
		System.out.println("I eat ANYTHING!!");
		
	}


}