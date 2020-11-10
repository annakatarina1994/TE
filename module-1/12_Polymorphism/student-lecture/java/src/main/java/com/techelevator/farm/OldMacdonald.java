package com.techelevator.farm;

import java.util.ArrayList;
import java.util.List;

public class OldMacdonald {
	public static void main(String[] args) {

//		FarmAnimal[] farmAnimals = new FarmAnimal[] { new Cow(), new Chicken(), new Pig(), new Sheep() };
		
		List<Singable> farmAnimals2 = new ArrayList<>();
		farmAnimals2.add(new Cow());
		farmAnimals2.add(new Pig());
		farmAnimals2.add(new Unicorn());
		farmAnimals2.add(new Elephant());
		farmAnimals2.add(new Chicken());
		farmAnimals2.add(new Sheep());
		

		for (FarmAnimal animal : farmAnimals) {
			String name = animal.getName();
			String sound = animal.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
			System.out.println();
		}
	}
}