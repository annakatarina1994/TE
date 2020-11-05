package com.techelevator;

public class AlienDemo {

	public static void main(String[] args) {
		Alien charlie = new Alien(); // this creates an object of type Alien named Charlie
		Alien mork = new Alien();
		
		charlie.setColor("Cornflower Blue");
		charlie.setHasBigHead(true);
		charlie.setPlanetOfOrigin("Earth");
		charlie.setIsHostile(true);
		
		System.out.println("Alien: Charlie");
		System.out.println("\nColor: " + charlie.getColor()); 
		System.out.println();
	}

}
