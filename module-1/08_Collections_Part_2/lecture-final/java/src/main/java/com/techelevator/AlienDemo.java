package com.techelevator;

public class AlienDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Alien charlie = new Alien();  // this creates an object of type Alien named charlie
		Alien mork = new Alien();     // this create an object of type Alien named mork

		charlie.setColor("Cornflower Blue");
		charlie.setHasBigHead(true);
		charlie.setPlanetOfOrigin("Earth");
		charlie.setIsHostile(true);
		
		System.out.println("Alien: Charlie ");
		System.out.println("\tColor: " + charlie.getColor());
		System.out.println("\tHas Big Head: " + charlie.getHasBigHead());
		System.out.println("\tPlanet of Origin: " + charlie.getPlanetOfOrigin());
		System.out.println("\tIs Hostile: " + charlie.getIsHostile());
		
		mork.setColor("Pink Polka-Dot");
		System.out.println("Alien: Mork ");
		System.out.println("\tColor: " + mork.getColor());
		System.out.println("\tHas Big Head: " + mork.getHasBigHead());
		System.out.println("\tPlanet of Origin: " + mork.getPlanetOfOrigin());
		System.out.println("\tIs Hostile: " + mork.getIsHostile());
	}

}
