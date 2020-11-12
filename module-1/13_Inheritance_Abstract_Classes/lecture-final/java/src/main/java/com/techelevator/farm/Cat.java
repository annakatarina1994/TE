package com.techelevator.farm;

public final class Cat extends FarmAnimal { // final means cannot have any children or sub classes

	public Cat() {
		super("Cat", "meow");
	}

	@Override
	public void eat() {
		System.out.println("I eat mice");
		
	}
	
//	@Override
//	public String getSound() {
//		return "meow";
//	}							  this method is final in the parent class therefore cannot be overridden

}
