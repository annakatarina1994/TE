package com.techelevator.farm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OldMacdonald {
	public static void main(String[] args) {

//		FarmAnimal[] farmAnimals = new FarmAnimal[] { new Cow(), new Chicken(), new Pig(), 
//				new Sheep() };
		
		Singable[] farmAnimals2 = new Singable[] { new Cow(), new Tractor()};
		
		List<Singable> farmAnimals = new ArrayList<>();  // changed T from FarmAnimal(parent) to Singable (interface)
		farmAnimals.add(new Cow());
		farmAnimals.add(new Pig());
		farmAnimals.add(new Unicorn());
		farmAnimals.add(new Elephant());
		farmAnimals.add(new Chicken());
		farmAnimals.add(new Sheep());
		farmAnimals.add(new Tractor());
		
//		Singable sing = new Singable(); //-- not allowed to create single object

		for (Singable animal : farmAnimals) {
			String name = animal.getName();
			String sound = animal.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
			System.out.println();
	//		animal.getPrice();  // cannot do this
		}
		
		Cow cow = (Cow) farmAnimals.get(0); // Cast to convert from Singable to Cow
		Chicken chicken = (Chicken) farmAnimals.get(4);
		Scanner input = new Scanner(System.in);
		System.out.println("Want to buy my cow? ");
		System.out.println("Price is " + cow.getPrice());
		String answer = input.nextLine();
		
		if (answer.toLowerCase().charAt(0) == 'y') {
			System.out.println("The cow is yours!! (good riddance!)");
		}
		else {
			System.out.println("How about some products from my animals: ");
			Product[] products = new Product[] { cow, chicken };
			for (Product p : products) {
				System.out.println("For sale: " + p.getByProductName() +
						"  Price: " + p.getByProductCost());
			}
		}
	}
}